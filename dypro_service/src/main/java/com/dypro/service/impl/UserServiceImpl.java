package com.dypro.service.impl;

import com.dypro.dao.IUserDao;
import com.dypro.domain.Role;
import com.dypro.domain.UserInfo;
import com.dypro.service.IUserService;
import com.dypro.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;  //用户dao类
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
            userInfo = userDao.findByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成userDetails
      //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority());
        User user=new User(userInfo.getUsername(),userInfo.getPassword(), userInfo.getStatus() != 0,
                true,true,true,
                getAuthority(userInfo.getRoles()));
        return user;
    }
    /**
     * 创建一个List集合，装入角色描述
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() throws Exception{
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        //对密码进行加密
        userInfo.setPassword(BCryptPasswordEncoderUtils.encodePassword(userInfo.getPassword().toString()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(Integer id) {
        return userDao.findById(id);
    }


    @Override
    public List<Role> findOtherRoles(Integer id) {

        return userDao.findOtherRoles(id);
    }

    @Override
    public void addRoleToUser(Integer userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }

    @Override
    public void removeRoleToUser(Integer userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            userDao.removeRoleToUser(userId,roleId);
        }
    }

    @Override
    public UserInfo findUserByUsername(String username) throws Exception {
        return userDao.findByUserName(username);
    }

    @Override
    public void passwordUpdate(Integer id, String password) throws Exception {
        //先进行密码加密
        userDao.passwordUpdate(id,BCryptPasswordEncoderUtils.encodePassword(password.toString()));
    }

    @Override
    public void delUserToRole(Integer userId) throws Exception {
        userDao.delUserToRole(userId);
    }

    @Override
    public void delUserById(Integer userId) throws Exception {
        userDao.delUserById(userId);
    }
}

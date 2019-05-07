package com.dypro.service;

import com.dypro.domain.Role;
import com.dypro.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户信息
     *
     * @return
     * @throws Exception
     * @param page
     * @param size
     */
    List<UserInfo> findAll(int page, int size) throws Exception;

    /**
     * 保存所有用户信息
     *
     * @param userInfo
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 查询指定ID返回用户信息
     *
     * @param id
     * @return
     */
    UserInfo findById(Integer id) throws Exception;

    /**
     * 根据用户ID查询可添加的其他ROles
     *
     * @param id
     * @return
     */
    List<Role> findOtherRoles(Integer id);

    /**
     * 根据返回的roleId添加用户角色
     *
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(Integer userId, String[] roleIds) throws Exception;

    /**
     * 根据角色id删除用户绑定的角色
     *
     * @param userId
     * @param roleIds
     */
    void removeRoleToUser(Integer userId, String[] roleIds) throws Exception;

    /**
     * 根据用户名查找User
     *
     * @param username
     * @return
     */
    UserInfo findUserByUsername(String username) throws Exception;

    /**
     * 根据用户保存密码
     *
     * @param id
     * @param password
     */
    void passwordUpdate(Integer id, String password) throws Exception;

    /**
     * 根据用户Id删除中间表
     * * @param userid
     */
    void delUserToRole(Integer userid) throws Exception;

    /**
     * 根据用户ID删除中间表
     *
     * @param userid
     */
    void delUserById(Integer userid) throws Exception;


}

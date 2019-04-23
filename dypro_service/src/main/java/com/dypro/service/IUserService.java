package com.dypro.service;

import com.dypro.domain.Role;
import com.dypro.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 保存所有用户信息
     * @param userInfo
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 查询指定ID返回用户信息
     * @param id
     * @return
     */
    UserInfo findById(Integer id) throws Exception;

    /**
     * 根据用户ID查询可添加的其他ROles
     * @param i
     * @return
     */
    List<Role> findOtherRoles(Integer id);

    /**
     * 根据返回的roleId添加用户角色
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(Integer userId, String[] roleIds) throws Exception;
}

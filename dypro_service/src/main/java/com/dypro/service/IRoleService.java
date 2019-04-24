package com.dypro.service;

import com.dypro.domain.Permission;
import com.dypro.domain.Role;

import java.util.List;

/**
 * 角色处理
 */
public interface IRoleService {
    /**
     * 查询所有信息
     * @return
     */
    List<Role> findAll() throws Exception;

    /**
     * 保存角色用户信息
     * @param role
     * @throws Exception
     */
    void save(Role role) throws Exception;

    /**
     * 根据角色ID查询
     * @param roleId
     * @return
     */
    Role findById(Integer roleId) throws Exception;

    /**
     * 查询权限资源
     * @param roleId
     * @return
     */
    List<Permission> findOtherPermission(Integer roleId) throws Exception;

    void addPermissionToRole(Integer id, String[] permissionIds) throws Exception;
}

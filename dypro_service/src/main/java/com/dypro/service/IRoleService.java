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
     * @param page
     * @param size
     */
    List<Role> findAll(int page, int size) throws Exception;

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

    /**
     * 添加权限给角色
     * @param id
     * @param permissionIds
     * @throws Exception
     */
    void addPermissionToRole(Integer id, String[] permissionIds) throws Exception;

    /**
     * 角色更新
     * @param role
     */
    void roleUpdate(Role role) throws Exception;

    /**
     * 根据角色ID与权限资源ID移除权限资源
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    void removePermissionToRole(Integer roleId, String[] permissionIds)throws Exception;

    /**
     * 根据用户id删除所拥有的所有权限
     * @param roleid
     */
    void delRoleToPermission(Integer roleid) throws Exception;

    /**
     * 根据角色id删除角色
     * @param roleid
     */
    void delRoleById(Integer roleid) throws Exception;
}

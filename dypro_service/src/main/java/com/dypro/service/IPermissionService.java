package com.dypro.service;

import com.dypro.domain.Permission;

import java.util.List;

/**
 * 权限管理业务操作
 */
public interface IPermissionService {

    /**
     * 查询所有权限信息
     * @return
     * @throws Exception
     */
    List<Permission> findAll() throws Exception;

    /**
     * 保存权限资源信息
     * @param permission
     * @throws Exception
     */
    void save(Permission permission) throws Exception;

    /**
     * 根据ID返回权限资源对象
     * @param permissionId
     * @return
     * @throws Exception
     */
    Permission findById(Integer permissionId) throws Exception;

    /**
     * 根据权限用户更新
     * @param permission
     * @throws Exception
     */
    void permissionUpdate(Permission permission) throws Exception;

    /**
     * 判断是否有用户在使用该权限
     * @param permissionId
     * @return
     */
    boolean findUsedRoleById(Integer permissionId) throws Exception;

    /**
     * 根据权限ID删除该权限
     * @param permissionId
     */
    void delPermissionById(Integer permissionId) throws Exception;
}

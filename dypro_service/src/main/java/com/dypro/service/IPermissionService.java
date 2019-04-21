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
}

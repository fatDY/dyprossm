package com.dypro.service;

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
}

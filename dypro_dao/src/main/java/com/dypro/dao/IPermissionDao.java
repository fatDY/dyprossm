package com.dypro.dao;

import com.dypro.domain.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 权限功能
 */

public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleid}) ")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissionName", column = "permissionName"),
            @Result(property = "url", column = "url"),
    })
    List<Permission> findPermissionByRoleId(@Param("roleid") Integer id) throws Exception;

    /**
     * 查询所有权限信息
     * @return
     */
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;
}
package com.dypro.dao;

import com.dypro.domain.Permission;
import org.apache.ibatis.annotations.*;

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
     *
     * @return
     */
    @Select("select * from permission order by id desc")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);

    @Select("select * from permission where id=#{permissionId} ")
    Permission findById(@Param("permissionId") Integer permissionId);

    @Update("update permission set permissionName=#{permissionName},URL=#{url} where id=#{id}")
    void permissionUpdate(Permission permission);

    @Select("select roleId from role_permission where permissionId=#{permissionId}")
    List<String> findUsedRoleById(@Param("permissionId") Integer permissionId) throws Exception;

    @Delete("delete from permission where id=#{permissionId}")
    void delPermissionById(@Param("permissionId") Integer permissionId) throws Exception;
}
package com.dypro.dao;

import com.dypro.domain.Permission;
import com.dypro.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 封装角色Dao
 */
public interface IRoleDao {
    /**
     * 根据用户id查询角色信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userID})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.dypro.dao.IPermissionDao.findPermissionByRoleId"))

    })
    List<Role> findRoleByUserId(@Param("userId") Integer userId) throws Exception;

    @Select("select * from role order by id desc")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.dypro.dao.IPermissionDao.findPermissionByRoleId"))

    })
    Role findByID(@Param("roleId") Integer roleId) throws Exception;

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId= #{roleId})")
    List<Permission> findOtherPermission(@Param("roleId") Integer roleId) throws Exception;

    @Insert("insert into role_permission (roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") Integer id, @Param("permissionId") String permissionId) throws Exception;

    @Update("update role set roleName=#{roleName},roleDesc=#{roleDesc} where id=#{id}")
    void roleUpdate(@Param("id") Integer id, @Param("roleName") String roleName, @Param("roleDesc") String roleDesc) throws Exception;

    @Delete("delete from role_permission where roleId=#{roleId} and permissionId=#{permissionId}")
    void removePermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") String permissionId);

    @Delete("delete from role_permission where roleId=#{roleId}")
    void delRoleToPermisson(@Param("roleId") Integer roleId);

    @Delete("delete from role where id=#{roleId}")
    void delRoleById(@Param("roleId") Integer roleId);

    @Select("select * from role where rolename=#{roleName}")
    Role findByName(@Param("roleName")String roleName) throws Exception;
}
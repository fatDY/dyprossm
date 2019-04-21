package com.dypro.dao;

import com.dypro.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 封装角色Dao
 */
public interface IRoleDao {
    /**
     * 根据用户id查询角色信息
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userID})")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column ="id",javaType =java.util.List.class,many = @Many(select = "com.dypro.dao.IPermissionDao.findPermissionByRoleId"))

    })
    List<Role> findRoleByUserId(@Param("userId") Integer userId) throws Exception;
    @Select("select * from role")
    List<Role> findAll() throws Exception;
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
}
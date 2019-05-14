package com.dypro.dao;

import com.dypro.domain.Role;
import com.dypro.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户类
 */
public interface IUserDao {
    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.dypro.dao.IRoleDao.findRoleByUserId"))

    }
    )
    UserInfo findByUserName(@Param("username") String username) throws Exception;

    @Select("select * from users order by id desc")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(username,password,status) value(#{username},#{password},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id = #{userid}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.dypro.dao.IRoleDao.findRoleByUserId"))

    }
    )
    UserInfo findById(@Param("userid") Integer id);

    @Select("select * from role where id not in(select roleId from users_role " +
            "where userId=#{userId})")
    List<Role> findOtherRoles(Integer id);

    @Insert("insert into users_role (userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") String roleId) throws Exception;

    @Update("update users set password =#{password} where id=#{id}")
    void passwordUpdate(@Param("id") Integer id, @Param("password") String password) throws Exception;

    @Delete("delete from users_role where userId = #{userId}")
    void delUserToRole(@Param("userId") Integer userId) throws Exception;

    @Delete("delete from users where id=#{userId}")
    void delUserById(@Param("userId") Integer userId) throws Exception;

    @Delete("delete from users_role where userId=#{userId} && roleId=#{roleId}")
    void removeRoleToUser(@Param("userId") Integer userId, @Param("roleId") String roleId)
            throws Exception;
}

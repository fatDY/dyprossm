package com.dypro.service;

import com.dypro.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 保存所有用户信息
     * @param userInfo
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 查询指定ID返回用户信息
     * @param id
     * @return
     */
    UserInfo findById(Integer id) throws Exception;
}

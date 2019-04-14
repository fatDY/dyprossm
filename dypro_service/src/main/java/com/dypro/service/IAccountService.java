package com.dypro.service;

import com.dypro.domain.Account;

import java.util.List;

public interface IAccountService {
    /**
     * 业务层查询所有账户信息
     * @return
     * @throws Exception
     */
    public List<Account> findAll() throws Exception;
}

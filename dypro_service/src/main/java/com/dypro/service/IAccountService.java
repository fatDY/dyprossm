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

    /**
     * 业务层根据指定账户号码查询账户信息
     * @param accountNo
     * @return
     * @throws Exception
     */
    public Account selectByAccountNo(String accountNo) throws Exception;

    /**
     * 根据ID查询账户
     * @param id
     * @return
     * @throws Exception
     */
    Account findById(Integer id) throws Exception;
}

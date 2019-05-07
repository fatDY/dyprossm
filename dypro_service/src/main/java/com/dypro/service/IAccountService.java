package com.dypro.service;

import com.dypro.domain.Account;

import java.util.List;

public interface IAccountService {
    /**
     * 业务层查询所有账户信息
     * @return
     * @throws Exception
     * @param page
     * @param size
     */
    List<Account> findAll(int page, int size) throws Exception;

    /**
     * 业务层根据指定账户号码查询账户信息
     * @param accountNo
     * @return
     * @throws Exception
     */
    Account selectByAccountNo(String accountNo) throws Exception;

    /**
     * 根据ID查询账户
     * @param id
     * @return
     * @throws Exception
     */
    Account findById(Integer id) throws Exception;

    /**
     * 根据账户号获得账户信息
     * @param accountNo
     * @return
     */
    Account findByAccountNo(String accountNo) throws Exception;

    /**
     * 保存账号
     * @param account
     * @param banksId
     */
    void save(Account account, String banksId) throws Exception;

    /**
     * 将账户设为注销
     * @param accountId
     */
    void setDelAccount(Integer accountId) throws Exception;
}

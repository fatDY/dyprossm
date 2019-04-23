package com.dypro.service;

import com.dypro.domain.Bank;

import java.util.List;

/**
 * 银行业务层接口
 */
public interface IBankService {
    /**
     * 根据银行id返回所有银行信息
     * @param id
     * @return
     */
    Bank selectById(Integer id) throws Exception;

    /**
     * 查询银行所有信息
     * @return
     */
    List<Bank> findAll() throws Exception;
    /**
     * 插入银行信息
     */
    void insertBank(Bank bank) throws Exception;
}

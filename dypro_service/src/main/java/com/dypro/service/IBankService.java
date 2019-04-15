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
    public Bank selectById(Integer id);

    /**
     * 查询银行所有信息
     * @return
     */
    public List<Bank> findAll();
    /**
     * 插入银行信息
     */
    public void insertBank(Bank bank);
}

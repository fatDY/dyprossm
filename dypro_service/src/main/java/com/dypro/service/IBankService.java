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
     * @param page
     * @param size
     */
    List<Bank> findAll(int page, int size) throws Exception;
    /**
     * 插入银行信息
     */
    void insertBank(Bank bank) throws Exception;

    /**
     * 根据联行号查找银行
     * @param uniteCode
     * @return
     */
    Bank findByUniteCode(String uniteCode) throws Exception;

    /**
     * 更新银行信息
     * @param bank
     */
    void update(Bank bank) throws Exception;
}

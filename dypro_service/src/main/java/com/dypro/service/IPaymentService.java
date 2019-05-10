package com.dypro.service;

import com.dypro.domain.Payment;

import java.util.List;

public interface IPaymentService {
    /**
     * 查询所有
     * @return
     * @throws Exception
     * @param page
     * @param size
     */
    List<Payment> findAll(int page, int size) throws Exception;

    /**
     * 根据Id查询付款单据
     * @param paymentId
     * @return
     */
    Payment findById(Integer paymentId) throws  Exception;

    /**
     * 根据付款单号查询付款单据
     * @param random
     * @return
     * @throws Exception
     */
    Payment findByPaymentId(String random) throws Exception;

    /**
     * 保存付款单
     * @param payment
     * @param accountId
     */
    void save(Payment payment, Integer accountId) throws Exception;

    /**
     * 更新付款单
     * @param payment
     * @param accountId
     * @throws Exception
     */
    void update(Payment payment, Integer accountId) throws Exception;

    /**
     * 删除付款单
     * @param ids
     */
    void delPaymentById(String[] ids) throws Exception;

    /**
     * 单据状态变为复核中
     * @param id
     * @param i
     * @throws Exception
     */
    void updateConfirmPayment(String id, String i) throws Exception;

    /**
     * 单据状态为复核的单据
     * @param page
     * @param size
     * @return
     */
    List<Payment> findAllConfirm(int page, int size) throws Exception;

    /**
     * 查询所有银行指令付款单据
     * @param page
     * @param size
     * @return
     */
    List<Payment> findPaymentToBank(int page, int size) throws Exception;
}

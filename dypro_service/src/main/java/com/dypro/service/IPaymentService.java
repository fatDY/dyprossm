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
}

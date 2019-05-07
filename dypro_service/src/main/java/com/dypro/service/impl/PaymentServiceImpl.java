package com.dypro.service.impl;

import com.dypro.dao.IPaymentDao;
import com.dypro.domain.Payment;
import com.dypro.service.IPaymentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private IPaymentDao paymentDao;

    @Override
    public List<Payment> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return paymentDao.findAll();
    }

}

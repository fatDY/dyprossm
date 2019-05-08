package com.dypro.service.impl;

import com.dypro.dao.IPaymentDao;
import com.dypro.domain.Payment;
import com.dypro.service.IPaymentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    @Override
    public Payment findById(Integer paymentId) throws Exception {
        return paymentDao.findById(paymentId);
    }

    @Override
    public Payment findByPaymentId(String random) throws Exception {
        return paymentDao.findByPaymentId(random);
    }

    @Override
    public void save(Payment payment, Integer accountId) throws Exception {
        String recProvince = payment.getRecProvince();
        String reCity = payment.getReCity();
        String recUniteCode = payment.getRecUniteCode();
        String recBankName = payment.getRecBankName();
        String recName = payment.getRecName();
        String recAccount = payment.getRecAccount();
        String memo = payment.getMemo();
        String paymentId = payment.getPaymentId();
        BigDecimal paymentAmount = payment.getPaymentAmount();
        paymentDao.save(paymentId,paymentAmount,memo,recAccount,recName,recBankName,recUniteCode,reCity,recProvince,accountId);
    }

    @Override
    public void update(Payment payment, Integer accountId) {
        String recProvince = payment.getRecProvince();
        String reCity = payment.getReCity();
        String recUniteCode = payment.getRecUniteCode();
        String recBankName = payment.getRecBankName();
        String recName = payment.getRecName();
        String recAccount = payment.getRecAccount();
        String memo = payment.getMemo();
        String paymentId = payment.getPaymentId();
        BigDecimal paymentAmount = payment.getPaymentAmount();
        Integer id = payment.getId();
        paymentDao.update(id,paymentAmount,memo,recAccount,recName,recBankName,recUniteCode,reCity,recProvince,accountId);
    }

    @Override
    public void delPaymentById(String[] ids) throws Exception {
        for (String id : ids) {
            paymentDao.delPaymentById(id);
        }
    }

    @Override
    public void updateConfirmPayment(String id, String i) {
        paymentDao.updateConfirmPayment(id,i);
    }

    @Override
    public List<Payment> findAllConfirm(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return paymentDao.findAllConfirm();
    }

}

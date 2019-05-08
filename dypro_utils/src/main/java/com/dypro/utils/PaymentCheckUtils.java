package com.dypro.utils;

import com.dypro.domain.Payment;

import java.math.BigDecimal;

public class PaymentCheckUtils {

    public static String checkPayment(Payment payment, Integer accountId, String amount){
        if (payment.getPaymentId()!=null&&"".equals(payment.getPaymentId())){
            return "付款单据编号为空";
        }
        if (accountId!=null&&"".equals(accountId)){
            return "请选择付款账户";
        }
        if (payment.getMemo()!=null&&"".equals(payment.getMemo())){
            return "备注信息为空";
        }
        if (payment.getRecAccount()!=null&&"".equals(payment.getRecAccount())){
            return "收款方账户为空";
        }
        if (payment.getRecName()!=null&&"".equals(payment.getRecName())){
            return "收款方用户名为空";
        }
        if (payment.getRecBankName()!=null&&"".equals(payment.getRecBankName())){
            return "收款方银行名为空";
        }
        if (payment.getRecUniteCode()!=null&&"".equals(payment.getRecUniteCode())){
            return "收款方联行号为空";
        }
        if (payment.getRecUniteCode()!=null&&"".equals(payment.getRecUniteCode())){
            return "收款方联行号为空";
        }
        if (payment.getReCity()!=null&&"".equals(payment.getReCity())){
            return "收款方银行所在市为空";
        }
        if (payment.getRecProvince()!=null&&"".equals(payment.getRecProvince())){
            return "收款方银行所在省为空";
        }
        try {
            new BigDecimal(amount);
        } catch (Exception e) {
            return "请输入正确的金额数字";
        }
        return "";
    }
}

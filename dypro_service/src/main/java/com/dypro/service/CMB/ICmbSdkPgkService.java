package com.dypro.service.CMB;

import com.dypro.domain.Payment;
import com.dypro.domain.cmb.cmbSdkPgk;

public interface ICmbSdkPgkService {

    /**
     * 根据单据ID获取银行指令
     * @param paymentId
     * @return
     * @throws Exception
     */
    cmbSdkPgk findById(String paymentId) throws Exception;

    /**
     * 将付款单据存入银行指令
     * @param paymentInfo
     */
    void savePaymentToCmb(Payment paymentInfo) throws Exception;
}

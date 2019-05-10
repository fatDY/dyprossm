package com.dypro.service.CMB.impl;

import com.dypro.dao.CMB.ICmbSdkPgk;
import com.dypro.dao.CMB.IInfoDao;
import com.dypro.dao.CMB.ISdkPayDtx;
import com.dypro.dao.CMB.ISdkPayRqx;
import com.dypro.domain.Payment;
import com.dypro.domain.cmb.Info;
import com.dypro.domain.cmb.SdkPayDtx;
import com.dypro.domain.cmb.SdkPayRqx;
import com.dypro.domain.cmb.cmbSdkPgk;
import com.dypro.service.CMB.ICmbSdkPgkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ICmbSdkPgkServiceImpl implements ICmbSdkPgkService {
    @Autowired
    private ICmbSdkPgk cmbSdkPgkDao;
    @Autowired
    private IInfoDao InfoDao;
    @Autowired
    private ISdkPayRqx sdkPayRqxDao;
    @Autowired
    private ISdkPayDtx sdkPayDtxDao;
    @Autowired
    private cmbSdkPgk cmbSdkPgk;
    @Autowired
    private Info info;
    @Autowired
    private SdkPayRqx sdkPayRqx;
    @Autowired
    private SdkPayDtx sdkPayDtx;
    @Override
    public cmbSdkPgk findById(String paymentId) throws Exception {
        return cmbSdkPgkDao.findById(paymentId);
    }

    @Override
    public void savePaymentToCmb(Payment paymentInfo) {
        String paymentId=paymentInfo.getPaymentId();
        //存入表头info
        info.setFunnam("Payment");
        //存入sdkPayRqx
        //存入sdkPayDtx
        sdkPayDtx.setYurRef(paymentInfo.getPaymentId());
        sdkPayDtx.setDbtAcc(paymentInfo.getPaymentAccountId().getAccountNo());
        sdkPayDtx.setC_dbtBbk(paymentInfo.getPaymentAccountId().getBankId().getBankCity());
        sdkPayDtx.setTrsAmt(paymentInfo.getPaymentAmount());
        sdkPayDtx.setC_ccyNbr(paymentInfo.getPaymentAccountId().getCurrencyid());
        sdkPayDtx.setNuSage(paymentInfo.getPaymentAccountId().getAccountPurposeId());
        sdkPayDtx.setCrtAcc(paymentInfo.getRecAccount());
        sdkPayDtx.setCrtNam(paymentInfo.getRecName());
        sdkPayDtx.setCrtBnk(paymentInfo.getRecBankName());
        sdkPayDtx.setCrtpvc(paymentInfo.getRecProvince());
        sdkPayDtx.setCrtCty(paymentInfo.getReCity());

        //存入Info表
        try {
            InfoDao.save(info.getFunnam(),paymentId);
            sdkPayRqxDao.save(paymentId);
            sdkPayDtxDao.save(paymentId,sdkPayDtx.getYurRef(),sdkPayDtx.getDbtAcc(),sdkPayDtx.getC_dbtBbk(),
                    sdkPayDtx.getTrsAmt(),sdkPayDtx.getC_ccyNbr(),sdkPayDtx.getNuSage(),sdkPayDtx.getCrtAcc(),
                    sdkPayDtx.getCrtNam(),sdkPayDtx.getCrtBnk(),sdkPayDtx.getCrtpvc(),sdkPayDtx.getCrtCty());
            cmbSdkPgkDao.save(paymentId,paymentId,paymentId,paymentId);

        } catch (Exception e) {
            e.getMessage();
        }
    }
}

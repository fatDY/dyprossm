package com.dypro.domain.cmb;

import org.springframework.stereotype.Component;

/**
 * 付款指定
 */
@Component
public class cmbSdkPgk {
   // private String paymentId;
    private Info infoId;
    private SdkPayRqx sdkPayRqxId;
    private SdkPayDtx sdkPayDtxId;

  /*  public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }*/

    public Info getInfoId() {
        return infoId;
    }

    public void setInfoId(Info infoId) {
        this.infoId = infoId;
    }

    public SdkPayRqx getSdkPayRqxId() {
        return sdkPayRqxId;
    }

    public void setSdkPayRqxId(SdkPayRqx sdkPayRqxId) {
        this.sdkPayRqxId = sdkPayRqxId;
    }

    public SdkPayDtx getSdkPayDtxId() {
        return sdkPayDtxId;
    }

    public void setSdkPayDtxId(SdkPayDtx sdkPayDtxId) {
        this.sdkPayDtxId = sdkPayDtxId;
    }

    @Override
    public String toString() {
        return "cmbSdkPgk{" +
                "infoId=" + infoId +
                ", sdkPayRqxId=" + sdkPayRqxId +
                ", sdkPayDtxId=" + sdkPayDtxId +
                '}';
    }
}

package com.dypro.domain.cmb;

import org.springframework.stereotype.Component;

/**
 * 抬头信息
 */
@Component
public class Info {
 //   private String paymentId;//付款单据唯一Id
    private String funnam;//付款类别
    private String dattyp;//接收格式
    private String lgnam;//前置机登陆号

    /*public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }*/

    public String getFunnam() {
        return funnam;
    }

    public void setFunnam(String funnam) {
        this.funnam = funnam;
    }

    public String getDattyp() {
        return dattyp;
    }

    public void setDattyp(String dattyp) {
        this.dattyp = dattyp;
    }

    public String getLgnam() {
        return lgnam;
    }

    public void setLgnam(String lgnam) {
        this.lgnam = lgnam;
    }

    @Override
    public String toString() {
        return "Info{" +
                "funnam='" + funnam + '\'' +
                ", dattyp='" + dattyp + '\'' +
                ", lgnam='" + lgnam + '\'' +
                '}';
    }
}

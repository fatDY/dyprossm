package com.dypro.domain.cmb;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 付款信息
 */
@Component
public class SdkPayDtx {
    //private String paymentId;//单据ID
    private String yurRef;//单据ID
    private String eptDat;//期望日期，默认为当天
    private String eptTim;//期望时间，默认为即时
    private String dbtAcc;//付款账户号
    private String c_dbtBbk;//付方开户城市
    private BigDecimal trsAmt;//交易金额
    private String c_ccyNbr;//交易币种，目前默认为人民币
    private String stlChn;//结算方式代码，目前默认为N，普通方式
    private String nuSage;//账户用途
    private String crtAcc;//收款方账户
    private String crtNam;//收款方账户名
    private String crtBnk;//收方开户银行
    private String crtpvc;//收方省份
    private String crtCty;//收方账户
    private String crtSqn;//收方编号
    private String trsTyp;//业务种类，默认为100001，1010001为慈善

   /* public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }*/

    public String getYurRef() {
        return yurRef;
    }

    public void setYurRef(String yurRef) {
        this.yurRef = yurRef;
    }

    public String getEptDat() {
        return eptDat;
    }

    public void setEptDat(String eptDat) {
        this.eptDat = eptDat;
    }

    public String getEptTim() {
        return eptTim;
    }

    public void setEptTim(String eptTim) {
        this.eptTim = eptTim;
    }

    public String getDbtAcc() {
        return dbtAcc;
    }

    public void setDbtAcc(String dbtAcc) {
        this.dbtAcc = dbtAcc;
    }

    public String getC_dbtBbk() {
        return c_dbtBbk;
    }

    public void setC_dbtBbk(String c_dbtBbk) {
        this.c_dbtBbk = c_dbtBbk;
    }

    public BigDecimal getTrsAmt() {
        return trsAmt;
    }

    public void setTrsAmt(BigDecimal trsAmt) {
        this.trsAmt = trsAmt;
    }

    public String getC_ccyNbr() {
        return c_ccyNbr;
    }

    public void setC_ccyNbr(String c_ccyNbr) {
        this.c_ccyNbr = c_ccyNbr;
    }

    public String getStlChn() {
        return stlChn;
    }

    public void setStlChn(String stlChn) {
        this.stlChn = stlChn;
    }

    public String getNuSage() {
        return nuSage;
    }

    public void setNuSage(String nuSage) {
        this.nuSage = nuSage;
    }

    public String getCrtAcc() {
        return crtAcc;
    }

    public void setCrtAcc(String crtAcc) {
        this.crtAcc = crtAcc;
    }

    public String getCrtNam() {
        return crtNam;
    }

    public void setCrtNam(String crtNam) {
        this.crtNam = crtNam;
    }

    public String getCrtBnk() {
        return crtBnk;
    }

    public void setCrtBnk(String crtBnk) {
        this.crtBnk = crtBnk;
    }

    public String getCrtpvc() {
        return crtpvc;
    }

    public void setCrtpvc(String crtpvc) {
        this.crtpvc = crtpvc;
    }

    public String getCrtCty() {
        return crtCty;
    }

    public void setCrtCty(String crtCty) {
        this.crtCty = crtCty;
    }

    public String getCrtSqn() {
        return crtSqn;
    }

    public void setCrtSqn(String crtSqn) {
        this.crtSqn = crtSqn;
    }

    public String getTrsTyp() {
        return trsTyp;
    }

    public void setTrsTyp(String trsTyp) {
        this.trsTyp = trsTyp;
    }

    @Override
    public String toString() {
        return "SdkPayDtx{" +
                "yurRef='" + yurRef + '\'' +
                ", eptDat='" + eptDat + '\'' +
                ", eptTim='" + eptTim + '\'' +
                ", dbtAcc='" + dbtAcc + '\'' +
                ", c_dbtBbk='" + c_dbtBbk + '\'' +
                ", trsAmt='" + trsAmt + '\'' +
                ", c_ccyNbr='" + c_ccyNbr + '\'' +
                ", stlChn='" + stlChn + '\'' +
                ", nuSage='" + nuSage + '\'' +
                ", crtAcc='" + crtAcc + '\'' +
                ", crtNam='" + crtNam + '\'' +
                ", crtBnk='" + crtBnk + '\'' +
                ", crtpvc='" + crtpvc + '\'' +
                ", crtCty='" + crtCty + '\'' +
                ", crtSqn='" + crtSqn + '\'' +
                ", trsTyp='" + trsTyp + '\'' +
                '}';
    }
}

package com.dypro.domain;

import java.math.BigDecimal;

public class Payment {
    private int id; //主键
    private String paymentId; //付款单编号
    private String paymentDate; //付款日期
    private Account paymentAccountId; //付款账户
    private BigDecimal paymentAmount; //付款金额
    private String recName; //收款账户名
    private String statement;//单据状态
    private String recAccount;//收款账户号
    private String recBankName;//收款银行名
    private String recProvince;//收款省份
    private String reCity; //收款账户所在城市
    private String recUniteCode;//收款银行联行号
    private String memo;//备注

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getStatement() {
        if ("0".equals(statement)){
            statement="保存";
        }
        if ("1".equals(statement)){
            statement="提交中";
        }
        if ("2".equals(statement)){
            statement="指令发送中";
        }
        if (!"保存".equals(statement)&&!"提交中".equals(statement)&&!"指令发送中".equals(statement)){
            statement="未知";
        }
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Account getPaymentAccountId() {
        return paymentAccountId;
    }

    public void setPaymentAccountId(Account paymentAccountId) {
        this.paymentAccountId = paymentAccountId;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getRecAccount() {
        return recAccount;
    }

    public void setRecAccount(String recAccount) {
        this.recAccount = recAccount;
    }

    public String getRecBankName() {
        return recBankName;
    }

    public void setRecBankName(String recBankName) {
        this.recBankName = recBankName;
    }

    public String getRecProvince() {
        return recProvince;
    }

    public void setRecProvince(String recProvince) {
        this.recProvince = recProvince;
    }

    public String getReCity() {
        return reCity;
    }

    public void setReCity(String reCity) {
        this.reCity = reCity;
    }

    public String getRecUniteCode() {
        return recUniteCode;
    }

    public void setRecUniteCode(String recUniteCode) {
        this.recUniteCode = recUniteCode;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentId='" + paymentId + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", paymentAccountId=" + paymentAccountId +
                ", paymentAmount=" + paymentAmount +
                ", recName='" + recName + '\'' +
                ", statement='" + statement + '\'' +
                ", recAccount='" + recAccount + '\'' +
                ", recBankName='" + recBankName + '\'' +
                ", recProvince='" + recProvince + '\'' +
                ", reCity='" + reCity + '\'' +
                ", recUniteCode='" + recUniteCode + '\'' +
                '}';
    }
}

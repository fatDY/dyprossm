package com.dypro.domain;

/**
 * 账户信息
 */
public class Account {
    private int id; //主键
    private String currencyid; //币种
    private String accountNo; //账户号
    private String accountName; //账户名
    private String accountPurposeId; //账户用途
    private String bankId; //账户所属银行ID
    private String accountType; //账户性质

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(String currencyid) {
        this.currencyid = currencyid;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPurposeId() {
        return accountPurposeId;
    }

    public void setAccountPurposeId(String accountPurposeId) {
        this.accountPurposeId = accountPurposeId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", currencyid='" + currencyid + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountPurposeId='" + accountPurposeId + '\'' +
                ", bankId='" + bankId + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}

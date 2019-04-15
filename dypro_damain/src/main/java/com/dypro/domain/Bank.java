package com.dypro.domain;

public class Bank {
    private Integer id;//id
    private String bankName;//银行名称
    private String uniteCode;//联行号
    private String bankProvince;//省份
    private String bankCity;//城市

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getUniteCode() {
        return uniteCode;
    }

    public void setUniteCode(String uniteCode) {
        this.uniteCode = uniteCode;
    }

    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", uniteCode='" + uniteCode + '\'' +
                ", bankProvince='" + bankProvince + '\'' +
                ", bankCity='" + bankCity + '\'' +
                '}';
    }
}

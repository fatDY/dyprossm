package com.dypro.domain;

public class Bank {
    private Integer id;//id
    private String bankName;//银行名称
    private String uniteCode;//联行号
    private String location;//地址多余字段

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", uniteCode='" + uniteCode + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

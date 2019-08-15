package com.java.pojo;

public class PolicyHolder {
    private Integer phId;

    private String phName;

    private String phSex;

    private String phCertificateType;

    private String phCardNumber;

    private String phTel;

    private String phAddress;

    public PolicyHolder(Integer phId, String phName, String phSex, String phCertificateType, String phCardNumber, String phTel, String phAddress) {
        this.phId = phId;
        this.phName = phName;
        this.phSex = phSex;
        this.phCertificateType = phCertificateType;
        this.phCardNumber = phCardNumber;
        this.phTel = phTel;
        this.phAddress = phAddress;
    }

    public PolicyHolder() {
        super();
    }

    public Integer getPhId() {
        return phId;
    }

    public void setPhId(Integer phId) {
        this.phId = phId;
    }

    public String getPhName() {
        return phName;
    }

    public void setPhName(String phName) {
        this.phName = phName == null ? null : phName.trim();
    }

    public String getPhSex() {
        return phSex;
    }

    public void setPhSex(String phSex) {
        this.phSex = phSex == null ? null : phSex.trim();
    }

    public String getPhCertificateType() {
        return phCertificateType;
    }

    public void setPhCertificateType(String phCertificateType) {
        this.phCertificateType = phCertificateType == null ? null : phCertificateType.trim();
    }

    public String getPhCardNumber() {
        return phCardNumber;
    }

    public void setPhCardNumber(String phCardNumber) {
        this.phCardNumber = phCardNumber == null ? null : phCardNumber.trim();
    }

    public String getPhTel() {
        return phTel;
    }

    public void setPhTel(String phTel) {
        this.phTel = phTel == null ? null : phTel.trim();
    }

    public String getPhAddress() {
        return phAddress;
    }

    public void setPhAddress(String phAddress) {
        this.phAddress = phAddress == null ? null : phAddress.trim();
    }
}
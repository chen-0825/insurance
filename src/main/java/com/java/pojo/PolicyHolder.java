package com.java.pojo;

public class PolicyHolder {
    private Integer phId;

    private String phName;

    private String phSex;

    private String phCredType;

    private String phCredNumber;

    private String phTel;

    private String phAddress;

    public PolicyHolder(Integer phId, String phName, String phSex, String phCredType, String phCredNumber, String phTel, String phAddress) {
        this.phId = phId;
        this.phName = phName;
        this.phSex = phSex;
        this.phCredType = phCredType;
        this.phCredNumber = phCredNumber;
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

    public String getPhCredType() {
        return phCredType;
    }

    public void setPhCredType(String phCredType) {
        this.phCredType = phCredType == null ? null : phCredType.trim();
    }

    public String getPhCredNumber() {
        return phCredNumber;
    }

    public void setPhCredNumber(String phCredNumber) {
        this.phCredNumber = phCredNumber == null ? null : phCredNumber.trim();
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
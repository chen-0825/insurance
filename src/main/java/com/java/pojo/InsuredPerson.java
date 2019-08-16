package com.java.pojo;

public class InsuredPerson {
    private Integer ipId;

    private String ipName;

    private String ipSex;

    private String ipTel;

    private String ipEmail;

    private String ipCertificateType;

    private String ipIdentificationNumber;

    private String ipAddress;

    private String ipBankAccount;

    private String ipDirverLicense;

    private String phName;

    public InsuredPerson(Integer ipId, String ipName, String ipSex, String ipTel, String ipEmail, String ipCertificateType, String ipIdentificationNumber, String ipAddress, String ipBankAccount, String ipDirverLicense, String phName) {
        this.ipId = ipId;
        this.ipName = ipName;
        this.ipSex = ipSex;
        this.ipTel = ipTel;
        this.ipEmail = ipEmail;
        this.ipCertificateType = ipCertificateType;
        this.ipIdentificationNumber = ipIdentificationNumber;
        this.ipAddress = ipAddress;
        this.ipBankAccount = ipBankAccount;
        this.ipDirverLicense = ipDirverLicense;
        this.phName = phName;
    }

    public InsuredPerson() {
        super();
    }

    public Integer getIpId() {
        return ipId;
    }

    public void setIpId(Integer ipId) {
        this.ipId = ipId;
    }

    public String getIpName() {
        return ipName;
    }

    public void setIpName(String ipName) {
        this.ipName = ipName == null ? null : ipName.trim();
    }

    public String getIpSex() {
        return ipSex;
    }

    public void setIpSex(String ipSex) {
        this.ipSex = ipSex == null ? null : ipSex.trim();
    }

    public String getIpTel() {
        return ipTel;
    }

    public void setIpTel(String ipTel) {
        this.ipTel = ipTel == null ? null : ipTel.trim();
    }

    public String getIpEmail() {
        return ipEmail;
    }

    public void setIpEmail(String ipEmail) {
        this.ipEmail = ipEmail == null ? null : ipEmail.trim();
    }

    public String getIpCertificateType() {
        return ipCertificateType;
    }

    public void setIpCertificateType(String ipCertificateType) {
        this.ipCertificateType = ipCertificateType == null ? null : ipCertificateType.trim();
    }

    public String getIpIdentificationNumber() {
        return ipIdentificationNumber;
    }

    public void setIpIdentificationNumber(String ipIdentificationNumber) {
        this.ipIdentificationNumber = ipIdentificationNumber == null ? null : ipIdentificationNumber.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getIpBankAccount() {
        return ipBankAccount;
    }

    public void setIpBankAccount(String ipBankAccount) {
        this.ipBankAccount = ipBankAccount == null ? null : ipBankAccount.trim();
    }

    public String getIpDirverLicense() {
        return ipDirverLicense;
    }

    public void setIpDirverLicense(String ipDirverLicense) {
        this.ipDirverLicense = ipDirverLicense == null ? null : ipDirverLicense.trim();
    }

    public String getPhName() {
        return phName;
    }

    public void setPhName(String phName) {
        this.phName = phName == null ? null : phName.trim();
    }
}
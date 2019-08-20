package com.java.pojo;

public class InsuranceUser {
    private Integer iuId;

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

    private String phSex;

    private String phCertificateType;

    private String phIdentificationNumber;

    private String phTel;

    private String phAddress;

    public InsuranceUser(Integer iuId, String ipName, String ipSex, String ipTel, String ipEmail, String ipCertificateType, String ipIdentificationNumber, String ipAddress, String ipBankAccount, String ipDirverLicense, String phName, String phSex, String phCertificateType, String phIdentificationNumber, String phTel, String phAddress) {
        this.iuId = iuId;
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
        this.phSex = phSex;
        this.phCertificateType = phCertificateType;
        this.phIdentificationNumber = phIdentificationNumber;
        this.phTel = phTel;
        this.phAddress = phAddress;
    }

    public InsuranceUser() {
        super();
    }

    public Integer getIuId() {
        return iuId;
    }

    public void setIuId(Integer iuId) {
        this.iuId = iuId;
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

    public String getPhIdentificationNumber() {
        return phIdentificationNumber;
    }

    public void setPhIdentificationNumber(String phIdentificationNumber) {
        this.phIdentificationNumber = phIdentificationNumber == null ? null : phIdentificationNumber.trim();
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
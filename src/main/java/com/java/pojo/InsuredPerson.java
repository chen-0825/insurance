package com.java.pojo;

public class InsuredPerson {
    private Integer ipId;

    private String ipName;

    private String ipSex;

    private String ipEmail;

    private String ipCertificateType;

    private String ipCardNumber;

    private String ipPhoneNumber;

    private String ipAddress;

    private String ipDirverLicense;

    private String ipBankAccount;

    private String phName;

    private PolicyHolder policyHolder;

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
        this.ipName = ipName;
    }

    public String getIpSex() {
        return ipSex;
    }

    public void setIpSex(String ipSex) {
        this.ipSex = ipSex;
    }

    public String getIpEmail() {
        return ipEmail;
    }

    public void setIpEmail(String ipEmail) {
        this.ipEmail = ipEmail;
    }

    public String getIpCertificateType() {
        return ipCertificateType;
    }

    public void setIpCertificateType(String ipCertificateType) {
        this.ipCertificateType = ipCertificateType;
    }

    public String getIpCardNumber() {
        return ipCardNumber;
    }

    public void setIpCardNumber(String ipCardNumber) {
        this.ipCardNumber = ipCardNumber;
    }

    public String getIpPhoneNumber() {
        return ipPhoneNumber;
    }

    public void setIpPhoneNumber(String ipPhoneNumber) {
        this.ipPhoneNumber = ipPhoneNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpDirverLicense() {
        return ipDirverLicense;
    }

    public void setIpDirverLicense(String ipDirverLicense) {
        this.ipDirverLicense = ipDirverLicense;
    }

    public String getIpBankAccount() {
        return ipBankAccount;
    }

    public void setIpBankAccount(String ipBankAccount) {
        this.ipBankAccount = ipBankAccount;
    }

    public String getPhName() {
        return phName;
    }

    public void setPhName(String phName) {
        this.phName = phName;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    @Override
    public String toString() {
        return "InsuredPerson{" +
                "ipId=" + ipId +
                ", ipName='" + ipName + '\'' +
                ", ipSex='" + ipSex + '\'' +
                ", ipEmail='" + ipEmail + '\'' +
                ", ipCertificateType='" + ipCertificateType + '\'' +
                ", ipCardNumber='" + ipCardNumber + '\'' +
                ", ipPhoneNumber='" + ipPhoneNumber + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", ipDirverLicense='" + ipDirverLicense + '\'' +
                ", ipBankAccount='" + ipBankAccount + '\'' +
                ", phName='" + phName + '\'' +
                ", policyHolder=" + policyHolder +
                '}';
    }
}


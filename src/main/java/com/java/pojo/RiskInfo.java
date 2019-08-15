package com.java.pojo;

import java.util.Date;

public class RiskInfo {
    private String riskId;

    private Date reportingDate;

    private Date filingDate;

    private Date escapeDate;

    private String riskProvince;

    private String riskCity;

    private String riskArea;

    private String riskRoad;

    private String riskReason;

    private String riskReporter;

    private String riskReporterTel;

    private String riskDriver;

    private String riskDriverTel;

    private Date riskEndingDate;

    private String riskStates;

    public RiskInfo(String riskId, Date reportingDate, Date filingDate, Date escapeDate, String riskProvince, String riskCity, String riskArea, String riskRoad, String riskReason, String riskReporter, String riskReporterTel, String riskDriver, String riskDriverTel, Date riskEndingDate, String riskStates) {
        this.riskId = riskId;
        this.reportingDate = reportingDate;
        this.filingDate = filingDate;
        this.escapeDate = escapeDate;
        this.riskProvince = riskProvince;
        this.riskCity = riskCity;
        this.riskArea = riskArea;
        this.riskRoad = riskRoad;
        this.riskReason = riskReason;
        this.riskReporter = riskReporter;
        this.riskReporterTel = riskReporterTel;
        this.riskDriver = riskDriver;
        this.riskDriverTel = riskDriverTel;
        this.riskEndingDate = riskEndingDate;
        this.riskStates = riskStates;
    }

    public RiskInfo() {
        super();
    }

    public String getRiskId() {
        return riskId;
    }

    public void setRiskId(String riskId) {
        this.riskId = riskId == null ? null : riskId.trim();
    }

    public Date getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(Date reportingDate) {
        this.reportingDate = reportingDate;
    }

    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    public Date getEscapeDate() {
        return escapeDate;
    }

    public void setEscapeDate(Date escapeDate) {
        this.escapeDate = escapeDate;
    }

    public String getRiskProvince() {
        return riskProvince;
    }

    public void setRiskProvince(String riskProvince) {
        this.riskProvince = riskProvince == null ? null : riskProvince.trim();
    }

    public String getRiskCity() {
        return riskCity;
    }

    public void setRiskCity(String riskCity) {
        this.riskCity = riskCity == null ? null : riskCity.trim();
    }

    public String getRiskArea() {
        return riskArea;
    }

    public void setRiskArea(String riskArea) {
        this.riskArea = riskArea == null ? null : riskArea.trim();
    }

    public String getRiskRoad() {
        return riskRoad;
    }

    public void setRiskRoad(String riskRoad) {
        this.riskRoad = riskRoad == null ? null : riskRoad.trim();
    }

    public String getRiskReason() {
        return riskReason;
    }

    public void setRiskReason(String riskReason) {
        this.riskReason = riskReason == null ? null : riskReason.trim();
    }

    public String getRiskReporter() {
        return riskReporter;
    }

    public void setRiskReporter(String riskReporter) {
        this.riskReporter = riskReporter == null ? null : riskReporter.trim();
    }

    public String getRiskReporterTel() {
        return riskReporterTel;
    }

    public void setRiskReporterTel(String riskReporterTel) {
        this.riskReporterTel = riskReporterTel == null ? null : riskReporterTel.trim();
    }

    public String getRiskDriver() {
        return riskDriver;
    }

    public void setRiskDriver(String riskDriver) {
        this.riskDriver = riskDriver == null ? null : riskDriver.trim();
    }

    public String getRiskDriverTel() {
        return riskDriverTel;
    }

    public void setRiskDriverTel(String riskDriverTel) {
        this.riskDriverTel = riskDriverTel == null ? null : riskDriverTel.trim();
    }

    public Date getRiskEndingDate() {
        return riskEndingDate;
    }

    public void setRiskEndingDate(Date riskEndingDate) {
        this.riskEndingDate = riskEndingDate;
    }

    public String getRiskStates() {
        return riskStates;
    }

    public void setRiskStates(String riskStates) {
        this.riskStates = riskStates == null ? null : riskStates.trim();
    }
}
package com.java.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class RiskInfo {
    private String riskId;		//报案id 雪花算法生成

    private Date reportingDate;		//报案时间

    private Date filingDate;	//立案时间

    private Date escapeDate;	//出险时间

    private String riskProvince;	//出险地点省/直辖市
	
    private String riskCity;	//出险市

    private String riskArea;	//出险县区

    private String riskRoad;	//出险路段

    private String riskReason;	//出险原因

    private String riskReporter;	//报案人

    private String riskReporterTel;		//报案人电话

    private String riskDriver;	//出险司机

    private String riskDriverTel;	//司机电话

    private Date riskEndingDate;	//结案时间

    private String riskStates;	//案件状态
}
package com.java.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
@Data
public class Riskmessage {
    private Integer riskId;
    private String riskIdcard;
    private String riskPersonname;

    private String riskPolicysId;
    private Integer riskBnSerial;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date riskBnTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date riskLianTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date riskOuttime;

    private String riskOutprovince;

    private String riskOutcity;

    private String riskOutarea;

    private String riskOutroad;

    private String riskOuttype;

    private String riskProcess;

    private String riskReason;

    private String riskReporter;

    private String riskReportertel;

    private String riskDirver;

    private String riskDirvertel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date riskEndtime;

    private Integer riskHander;

    private Integer riskState;

    SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getRiskBnTime() {
        return stf.format(this.riskBnTime);
    }


    public String getRiskLianTime() {
        return stf.format(this.riskLianTime);
    }


    public String getRiskOuttime() {
        return stf.format(this.riskOuttime);
    }


    public String getRiskEndtime() {
        return stf.format(this.riskEndtime);
    }

}
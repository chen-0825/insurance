package com.java.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Policy {
    private String policyId;	//保单id 通过雪花算法生成

    private String ipId;	//被保人id

    private Date writtenDate;		//签单日期

    private Date startDate;		//保险起期

    private Date endingDate;		//保险止期

    private Date expendsDate;		//缴费时间

    private Double baofeizonge;		//保费总额

    private String policyType;		//保单类型

    private String policyState;		//保单状态

    private String insCode;			//保单险钟代码

    private String insName;		//保单险钟名称

    private Double toubaojine;		//投保金额

    private Double discount;	//优惠系数

    private Double baofeijine;	//保费金额

    private Double peichangxiane;	//赔偿限额

    private String vehiclesType;	//机动车类型

    private Date dateOfProduction;	//机动车出场日期

    private Integer passengerNumber;	//核定载客数

    private String licenseNumber;	//车辆行驶证

    private String nameOfOwner;		//车主姓名

    private Double carPrice;	//新车购置价

    private Date dateOfRegistration;	//初次登记日期

    private Integer serviceLife;	//实际使用年限

    private Integer drivingMileage;		//已行驶里程数
}
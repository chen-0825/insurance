package com.java.pojo;

import lombok.Data;

@Data
public class PolicyHolder {
    private String phId;	//投保人id,雪花算法生成

    private String phName;	//投保人姓名

    private String phSex;	//投保人性别

    private String phCredType;	//投保人证件类型

    private String phCredNumber;	//投保人证件号码

    private String phTel;	//投保人联系方式

    private String phAddress;	//投保人联系地址
}
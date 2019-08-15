package com.java.pojo;

import lombok.Data;

@Data
public class InsuredPerson {
    private String ipId;	//被保人id 通过雪花算法生成

    private String ipName;	//被保人姓名

    private String ipSex;	//被保人性别

    private String ipEmail;	//被保人邮箱

    private String ipCredType;	//被保人证件类型

    private String ipCredNumber;	//被保人证件号码

    private String ipAddress;	//被保人联系地址

    private String ipCardNumber;		//被保人银行帐户

    private String ipDirverLicense;		//被保人驾驶证号码

    private String ipPolicyHolderId;	//投保人id
}
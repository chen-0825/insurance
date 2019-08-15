package com.java.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zl
 * @create 2019-08-14 16:41
 */
//避免写set和get方法
@Data
public class Policys {
    private String policyId;

    private String recognizee;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date writtenDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endingDate;

    private Double baofeizonge;

    private String policyType;

    private String policyState;

    private Double peichangxiane;

    private String engine;

    private String vin;

    private String factoryPlateModel;

    private String plateNumber;

    private String color;

    private String vehiclesType;

    private Integer passengerNumber;

    private String drivingLicence;

    private String nameOfOwner;

    private Double carPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfRegistration;

    private Integer usefulYear;

    private Double drivingMileage;

    public Policys(String policyId, String recognizee, Date writtenDate, Date startDate, Date endingDate, Double baofeizonge, String policyType, String policyState, Double peichangxiane, String engine, String vin, String factoryPlateModel, String plateNumber, String color, String vehiclesType, Integer passengerNumber, String drivingLicence, String nameOfOwner, Double carPrice, Date dateOfRegistration, Integer usefulYear, Double drivingMileage) {
        this.policyId = policyId;
        this.recognizee = recognizee;
        this.writtenDate = writtenDate;
        this.startDate = startDate;
        this.endingDate = endingDate;
        this.baofeizonge = baofeizonge;
        this.policyType = policyType;
        this.policyState = policyState;
        this.peichangxiane = peichangxiane;
        this.engine = engine;
        this.vin = vin;
        this.factoryPlateModel = factoryPlateModel;
        this.plateNumber = plateNumber;
        this.color = color;
        this.vehiclesType = vehiclesType;
        this.passengerNumber = passengerNumber;
        this.drivingLicence = drivingLicence;
        this.nameOfOwner = nameOfOwner;
        this.carPrice = carPrice;
        this.dateOfRegistration = dateOfRegistration;
        this.usefulYear = usefulYear;
        this.drivingMileage = drivingMileage;
    }

    public Policys() {
        super();
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public String getStartDate() {

        return sdf.format(this.startDate);
    }

    public String getWrittenDate() {
        return sdf.format(this.writtenDate);
    }

    public String getEndingDate() {
        return sdf.format(this.endingDate);
    }

    public String getDateOfRegistration() {
        return sdf.format(this.dateOfRegistration);
    }

}

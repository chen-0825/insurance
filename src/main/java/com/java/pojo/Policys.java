package com.java.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zl
 * @create 2019-08-14 16:41
 */
//@Data避免写set和get方法
//@Data 条件查询会报错toString();
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


//    @Pattern(regexp="(^[\\u2E80-\\u9FFF]{2,5})",
//            message="请输入2-5位中文")
    private String nameOfOwner;

    private Double carPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfRegistration;

    private Integer usefulYear;

    private Double drivingMileage;


//    @Pattern(regexp="^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$",
//            message="身份证号格式不正确,请输入18位号码")
    private String idcard;

    public Policys() {
    }

    public Policys(String policyId, String recognizee, Date writtenDate, Date startDate, Date endingDate, Double baofeizonge, String policyType, String policyState, Double peichangxiane, String engine, String vin, String factoryPlateModel, String plateNumber, String color, String vehiclesType, Integer passengerNumber, String drivingLicence, String nameOfOwner, Double carPrice, Date dateOfRegistration, Integer usefulYear, Double drivingMileage, String idcard) {
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
        this.idcard = idcard;
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


    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getRecognizee() {
        return recognizee;
    }

    public void setRecognizee(String recognizee) {
        this.recognizee = recognizee;
    }


    public void setWrittenDate(Date writtenDate) {
        this.writtenDate = writtenDate;
    }


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Double getBaofeizonge() {
        return baofeizonge;
    }

    public void setBaofeizonge(Double baofeizonge) {
        this.baofeizonge = baofeizonge;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPolicyState() {
        return policyState;
    }

    public void setPolicyState(String policyState) {
        this.policyState = policyState;
    }

    public Double getPeichangxiane() {
        return peichangxiane;
    }

    public void setPeichangxiane(Double peichangxiane) {
        this.peichangxiane = peichangxiane;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getFactoryPlateModel() {
        return factoryPlateModel;
    }

    public void setFactoryPlateModel(String factoryPlateModel) {
        this.factoryPlateModel = factoryPlateModel;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehiclesType() {
        return vehiclesType;
    }

    public void setVehiclesType(String vehiclesType) {
        this.vehiclesType = vehiclesType;
    }

    public Integer getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(Integer passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }


    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Integer getUsefulYear() {
        return usefulYear;
    }

    public void setUsefulYear(Integer usefulYear) {
        this.usefulYear = usefulYear;
    }

    public Double getDrivingMileage() {
        return drivingMileage;
    }

    public void setDrivingMileage(Double drivingMileage) {
        this.drivingMileage = drivingMileage;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}

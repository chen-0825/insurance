package com.java.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Lp {
    private Integer id;

    private String lpPeople;

    private Integer lpMoney;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lpTime;

    private String lpStatus;

    private String status;

    public String getLpTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(lpTime == null){
            return "";
        }
        return sdf.format(this.lpTime);
    }
}

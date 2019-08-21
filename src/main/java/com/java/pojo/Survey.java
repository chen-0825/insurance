package com.java.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Survey {
    private int id;

    private int number;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    private String site;

    private String phone;

    private String status;

    private String name;

    private String dsStatus;

    private int money;

    private String wounded;

    private String photo;

    private String details;

}

package com.java.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 理赔管理
 */
@Data
public class Lpgl {
    private Integer id;

    private Integer pgId;

    private String pgName;

    private String xmName;

    private BigDecimal ssMoney;

    private BigDecimal pfMoney;

    private String lpId;

    private String lqPeople;

    private String lpFs;

    private String lpJz;

    private String lpSh;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lpTime;

    public String getLpTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.lpTime);
    }
}
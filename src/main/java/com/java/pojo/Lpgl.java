package com.java.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 理赔管理
 */
@Data
public class Lpgl {
    private Integer id;
    @NotNull
    private String xmName;
    @NotNull
    private BigDecimal ssMoney;
    @NotNull
    private BigDecimal pfMoney;

    private String lpId;
    @NotNull
    private String lqPeople;
    @NotNull
    private String lpFs;
    @NotNull
    private String lpSh;

    @Past
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lpTime;

    public String getLpTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(this.lpTime != null){
            return sdf.format(this.lpTime);
        }
        return "";
    }
}
package com.java.controller.guarantee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zl
 * @create 2019-08-11 19:32
 */
@Controller
public class guarantee {


    //进入保单页面
    @RequestMapping("guarantee")
    public String showGuarantee(){
        return "guarantee/guarantee";
    }

}

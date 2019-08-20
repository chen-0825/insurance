package com.java.controller;

import com.java.pojo.Area;
import com.java.pojo.City;
import com.java.pojo.Province;
import com.java.service.DiquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class DiquController {
    @Autowired
    private DiquService diquService;

    /*@RequestMapping("/index")
    public String index(){
        return "index";
    }*/
    @ResponseBody
    @RequestMapping("/getProvince")
    public List<Province> selProvince(){
        /*System.out.println(diquService.selProvince());*/
        return diquService.selProvince();
    }
    @ResponseBody
    @RequestMapping("/getCity")
    public List<City> selCity(String codeP){
        return diquService.selCity(codeP);
    }
    @ResponseBody
    @RequestMapping("/getArea")
    public List<Area> selArea(String codeC){
     /*   System.out.println(codeC);
        System.out.println(diquService.selArea(codeC));*/
        return diquService.selArea(codeC);
    }

}

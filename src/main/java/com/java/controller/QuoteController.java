package com.java.controller;

import com.java.pojo.HotCity;
import com.java.pojo.ZiCity;
import com.java.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @RequestMapping("/quote")
    public String quote(Model model){
        List<HotCity> hotCity = quoteService.findHotCity();
        model.addAttribute("hotCity",hotCity);
        return "quote/quoteprice";
    }

    @RequestMapping("/searchCity")
    public void searchCity(HttpServletResponse response, String city){
        System.out.println(city);
        List<ZiCity> cityByName = quoteService.findCityByName(city);
        if(cityByName.size()==0){
            //此处中文条件查询为空
            System.out.println("条件查询null");

            //调用拼音查询
            List<ZiCity> cityByPinyin = quoteService.findCityByPinyin(city);



        }else {
            for (ZiCity z:cityByName) {
                System.out.println(z.toString());
            }
        }

    }
}

package com.java.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.java.address.AddressUtils;
import com.java.pojo.AccessInfo;
import com.java.pojo.HotCity;
import com.java.pojo.ZiCity;
import com.java.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @RequestMapping("/quote")
    public String quote(Model model){
        AddressUtils addressUtils = new AddressUtils();

        //获取ip
        String ip = "58.48.227.192";
        String address = "";
        try {
            address = addressUtils.getAddresses("ip="+ip,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JSONObject jsonpObject = JSON.parseObject(address);
        String city = jsonpObject.getString("data");
        JSONObject jsonpObject1 = JSON.parseObject(city);
        String city1 = jsonpObject1.getString("city");
        model.addAttribute("firstcity",city1);

        List<HotCity> hotCity = quoteService.findHotCity();
        model.addAttribute("hotCity",hotCity);
        return "quote/quoteprice";
    }

    @RequestMapping("/searchCity")
    @ResponseBody
    public void searchCity(HttpServletResponse response, String city){
        System.out.println(city);
        List<ZiCity> cityByName = quoteService.findCityByName(city);

        if(cityByName.size()==0){
            //此处中文条件查询为空
            System.out.println("条件查询null");

            //调用拼音查询
            char[] chars = city.toCharArray();
            String cityString = "%";
            for(int i = 0; i < chars.length; i++){
                cityString += chars[i] + "%";
                System.out.println(cityString);
            }
            List<ZiCity> cityByPinyin = quoteService.findCityByPinyin(cityString);
            try {
                //拼音结果,启用回调函数
                String jsonString = JSON.toJSONString(cityByPinyin);
                System.out.println(jsonString);
                response.setContentType("text/html;charset=utf-8");
                PrintWriter writer = null;
                writer =response.getWriter();
                writer.print(jsonString);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {

            try {
                //中文结果,启用回调函数
                String jsonString = JSON.toJSONString(cityByName);
                System.out.println(jsonString);
                response.setContentType("text/html;charset=utf-8");
                PrintWriter writer = null;
                writer =response.getWriter();
                writer.print(jsonString);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @RequestMapping("/addAccessInfo")
    public String addAccessInfo(String city,String carnumber,String getTimeYear,String getTimeMonth,double carprice,String phonenumber,Model model){
        AccessInfo accessInfo = new AccessInfo();
        accessInfo.setAi_city(city);
        accessInfo.setAi_carnumber(carnumber);
        accessInfo.setAi_cargetTime(getTimeYear+"-"+getTimeMonth);
        accessInfo.setAi_carprice(carprice);
        accessInfo.setAi_phonenumber(phonenumber);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());

        accessInfo.setAi_time(time);
        quoteService.addAccessInfo(accessInfo);
        int price = (int) carprice;
        model.addAttribute("carprice",price);
        int total = (int) (carprice*40 + 3073 +960);
        model.addAttribute("totalprice",total);
        return "quote/policydetails";
    }

}

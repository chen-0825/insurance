package com.java.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.Riskmessage;
import com.java.service.DiquService;
import com.java.service.RiskMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RIskMessageController {
    @Autowired
    private RiskMessageService riskMessageService;
    @Autowired
    private DiquService diquService;
    @RequestMapping("/selAllRiskMessage")
    public String selAllRiskMessage(Model model,@RequestParam(value="pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,2);
        List<Riskmessage> list = riskMessageService.selAllRiskMessage();
        PageInfo<Riskmessage> pageInfo = new PageInfo<Riskmessage>(list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("list",pageInfo.getList());
        return "RiskMessage/RiskMessageIndex";
    }

    //添加出险信息
    @RequestMapping("/addMessageAction")
    public String addRiskMessage(Riskmessage riskmessage,String riskBnTime1,String riskLianTime1,String riskOuttime1,String riskEndtime1, Model model,@RequestParam(value="pn",defaultValue = "1") Integer pn){
        String riskBnTime2 = riskBnTime1.replace("T", " ");
        String riskOuttime2 = riskOuttime1.replace("T", " ");
        String riskEndtime2 = riskEndtime1.replace("T", " ");
        String riskLianTime2 = riskLianTime1.replace("T", " ");
        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String province = riskmessage.getRiskOutprovince();
        String city = riskmessage.getRiskOutcity();
        String area = riskmessage.getRiskOutarea();
        riskmessage.setRiskOutprovince(diquService.finProvince(province));
        riskmessage.setRiskOutcity(diquService.finCity(city));
        riskmessage.setRiskOutarea(diquService.finArea(area));
        try {
            Date riskBnTime = stf.parse(riskBnTime2);
            Date riskOuttime = stf.parse(riskOuttime2);
            Date riskEndtime = stf.parse(riskEndtime2);
            Date riskLianTime = stf.parse(riskLianTime2);
            riskmessage.setRiskBnTime(riskBnTime);
            riskmessage.setRiskOuttime(riskOuttime);
            riskmessage.setRiskEndtime(riskEndtime);
            riskmessage.setRiskLianTime(riskLianTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        riskMessageService.addRiskMessage(riskmessage);
            return this.selAllRiskMessage(model,pn);
    }
}

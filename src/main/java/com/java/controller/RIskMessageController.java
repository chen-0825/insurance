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
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String selAllRiskMessage(String riskHander,Model model,@RequestParam(value="pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,5);
        List<Riskmessage> list = riskMessageService.selAllRiskMessage(riskHander);
        PageInfo<Riskmessage> pageInfo = new PageInfo<Riskmessage>(list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("list",pageInfo.getList());
        return "RiskMessage/RiskMessageIndex";
    }

    //按条件查询
    @RequestMapping("/selRiskMessageBy")
    @ResponseBody
    public Riskmessage selAllRiskMessageBy(Riskmessage riskmessage){
        Riskmessage rk = riskMessageService.selAllRiskMessageBy(riskmessage);
       /* if (rk.getRiskHander().equals(1)){
            rk.setRiskHander("注销");
        }else if (rk.getRiskHander().equals(2)){
            rk.setRiskHander("受理");
        }else {
            rk.setRiskHander("暂存");

        }

        if (rk.getRiskState().equals(1)){
            rk.setRiskState("结案");
        }else if (rk.getRiskState().equals(2)){
            rk.setRiskState("予以立案");
        }else if (rk.getRiskState().equals(3)){
            rk.setRiskState("撤销");
        }else {
            rk.setRiskState("注销");
        }*/
//        System.out.println(rk);
        if (rk != null){
            return rk;
        }else {
            return null;
        }
    }


    //批量删除
    @ResponseBody
    @RequestMapping("/delSomeMessage")
    public int delSome(String id){
//        System.out.println(id);
        String[] ids = id.split(",");
        int count = riskMessageService.delSomeMessage(ids);
        if (count > 0){
            return 1;
        }else {
            return 0;
        }
    }

    //删除单条
    @RequestMapping("/delRiskMessage")
    public String delRiskMessage(String riskHander,Integer riskId,Model model,@RequestParam(value="pn",defaultValue = "1") Integer pn){
        riskMessageService.delRiskMessage(riskId);
        return this.selAllRiskMessage(riskHander,model,pn);
    }

    //添加出险信息
    @RequestMapping("/addMessageAction")
    public String addRiskMessage(String riskHander,Riskmessage riskmessage,String riskBnTime1,String riskLianTime1,String riskOuttime1,String riskEndtime1, Model model,@RequestParam(value="pn",defaultValue = "1") Integer pn){
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
            return this.selAllRiskMessage(riskHander,model,pn);
    }

    //修改状态信息
    @RequestMapping("/updateRiskMessage")
    public String updateRiskMessage(String riskHander,Riskmessage riskmessage,Model model,@RequestParam(value="pn",defaultValue = "1") Integer pn){
        riskMessageService.updateRiskMessage(riskmessage);
       return this.selAllRiskMessage(riskHander,model,pn);
    }
}

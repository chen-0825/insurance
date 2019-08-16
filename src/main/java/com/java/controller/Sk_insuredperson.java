package com.java.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.InsuredPerson;
import com.java.service.InsuredPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class Sk_insuredperson {
    @Autowired
    private InsuredPersonService insuredpersonService;

    //   被保人删除
    @RequestMapping("/ip_delete")
    public String ipdelete(InsuredPerson insuredperson, Model model) {
        int count = insuredpersonService.delete(insuredperson);
        return "redirect:ip_index";
    }

    //   被保人添加
    @RequestMapping("/ip_zj")
    public String ipadd(InsuredPerson insuredperson, Model model)  {
        int count = insuredpersonService.add(insuredperson);
        return "redirect:ip_index";
    }

//    中转站
    @RequestMapping("/ip_zzz")
   public String ipzzz(Model model){

       return "sk_insuredperson/add";
   }


    //   被保人查单条
    @RequestMapping("/ip_findOne")
    public String ipfindOne(InsuredPerson insuredperson, Model model) {
        InsuredPerson i = insuredpersonService.findOne(insuredperson);
        model.addAttribute("i", i);
        return "sk_insuredperson/update";
    }


    //    被保人修改
    @RequestMapping("/ip_xg")
    public String ipupdate(InsuredPerson insuredperson, Model model) {
        int count = insuredpersonService.update(insuredperson);
        System.out.println(insuredperson);
        return "redirect:ip_index";
    }

    //被保人批量删
    @ResponseBody
    @RequestMapping("ip_batchDelete")
    public String ipbatchDelete(String id) {
        String[] ipId = id.split(",");
        int count = insuredpersonService.batchDelete(ipId);
        if (count > 0) {
            return "1";
        }
        return "0";
    }

//       被保人查所有  分页
    @RequestMapping("ip_index")
    public String ipfindAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        // 引入pagehelper插件
        // 传入页码,及每页条数
        PageHelper.startPage(pn, 6);
        // startPage后紧跟的查询就是分页查询
        List<InsuredPerson> list = insuredpersonService.findAll();
        // 使用pageInfo包装查询后的结果
        // 封装了分页的详情信息,和查询出来的结果
        PageInfo pageInfo = new PageInfo(list, 5);// 传入连续显示的页数
        model.addAttribute("pageInfo", pageInfo);
        return "sk_insuredperson/insuredperson";
    }

    // 被保人多条件查询
    @RequestMapping("/ip_cx")
    public String ipfindSelf(@RequestParam(value = "pn", defaultValue = "1")  Integer pn, InsuredPerson insuredperson, Model model) {
        // 引入pagehelper插件
        // 传入页码,及每页条数
        PageHelper.startPage(pn, 6);
        // startPage后紧跟的查询就是分页查询
        List<InsuredPerson> list = insuredpersonService.searchOne(insuredperson);
        // 使用pageInfo包装查询后的结果
        // 封装了分页的详情信息,和查询来的结果
        PageInfo pageInfo = new PageInfo(list, 5);// 传入连续显示的页数
        model.addAttribute("pageInfo", pageInfo);
        if (insuredperson.getIpName()=="" && insuredperson.getIpIdentificationNumber()==""){

            return "redirect:ip_index";

        }
        return "sk_insuredperson/cx";
    }
}
package com.java.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.InsuranceUser;
import com.java.service.InsuranceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Sk_insuranceuser {

    @Autowired
    private InsuranceUserService insuranceuserService;

    //   保险用户删除
    @RequestMapping("/iu_delete")
    public String iudelete(InsuranceUser insuranceuser, Model model) {
        int count = insuranceuserService.delete(insuranceuser);
        return "redirect:iu_index";
    }

    //   保险用户添加
    @RequestMapping("/iu_zj")
    public String iuadd(InsuranceUser insuranceuser, Model model)  {
        int count = insuranceuserService.add(insuranceuser);
        return "redirect:iu_index";
    }

//    中转站
    @RequestMapping("/iu_zzz")
   public String iuzzz(Model model){

       return "sk_insuranceuser/add";
   }


    // 保险用户查单条
    @RequestMapping("/iu_findOne")
    public String iufindOne(InsuranceUser insuranceuser, Model model) {
        InsuranceUser i = insuranceuserService.findOne(insuranceuser);
        model.addAttribute("i", i);
        return "sk_insuranceuser/update";
    }

    // 投保人查单条
    @RequestMapping("/iu_tbr")
    public String iutbr(InsuranceUser insuranceuser, Model model) {
        InsuranceUser t = insuranceuserService.findOne(insuranceuser);
        model.addAttribute("t", t);
        return "sk_insuranceuser/tbr";
    }


    // 保险用户修改
    @RequestMapping("/iu_xg")
    public String iuupdate(InsuranceUser insuranceuser, Model model) {
        int count = insuranceuserService.update(insuranceuser);
        return "redirect:iu_index";
    }

    //保险用户批量删
    @ResponseBody
    @RequestMapping("iu_batchDelete")
    public String iubatchDelete(String id) {
        String[] iuId = id.split(",");
        int count = insuranceuserService.batchDelete(iuId);
        if (count > 0) {
            return "1";
        }
        return "0";
    }

    // 保险用户查所有  分页
    @RequestMapping("iu_index")
    public String iufindAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        // 引入pagehelper插件
        // 传入页码,及每页条数
        PageHelper.startPage(pn, 6);
        // startPage后紧跟的查询就是分页查询
        List<InsuranceUser> list = insuranceuserService.findAll();
        // 使用pageInfo包装查询后的结果
        // 封装了分页的详情信息,和查询出来的结果
        PageInfo pageInfo = new PageInfo(list, 5);// 传入连续显示的页数
        model.addAttribute("pageInfo", pageInfo);
        return "sk_insuranceuser/insuranceuser";
    }

    // 保险用户多条件查询
    @RequestMapping("/iu_cx")
    public String iufindSelf(@RequestParam(value = "pn", defaultValue = "1")  Integer pn, InsuranceUser insuranceuser, Model model) {
        // 引入pagehelper插件
        // 传入页码,及每页条数
        PageHelper.startPage(pn, 6);
        // startPage后紧跟的查询就是分页查询
        List<InsuranceUser> list = insuranceuserService.searchOne(insuranceuser);
        // 使用pageInfo包装查询后的结果
        // 封装了分页的详情信息,和查询来的结果
        PageInfo pageInfo = new PageInfo(list, 5);// 传入连续显示的页数
        model.addAttribute("pageInfo", pageInfo);
        if (insuranceuser.getPhName()=="" && insuranceuser.getPhIdentificationNumber()=="" && insuranceuser.getIpName()=="" && insuranceuser.getIpIdentificationNumber()==""){

            return "redirect:iu_index";

        }
        return "sk_insuranceuser/cx";
    }
}
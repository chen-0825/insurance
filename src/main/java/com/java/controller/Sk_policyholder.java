package com.java.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.PolicyHolder;
import com.java.service.PolicyHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Sk_policyholder {
//    用户
    @Autowired
    private PolicyHolderService policyholderService;

    //   投保人删除
    @RequestMapping("/ph_delete")
    public String phdelete(PolicyHolder policyholder, Model model) {
        int count = policyholderService.delete(policyholder);
        return "ph_index";
    }

    //   投保人添加
    @RequestMapping("/ph_zj")
    public String phadd(PolicyHolder policyholder, Model model)  {
        int count = policyholderService.add(policyholder);
        return "redirect:ph_index";
    }

    //   投保人查单条
    @RequestMapping("/ph_findOne")
    public String phfindOne(PolicyHolder policyholder, Model model) {
        PolicyHolder p = policyholderService.findOne(policyholder);
        model.addAttribute("p", p);
        return "sk_policyholder/update.jsp";
    }


    //    投保人修改
    @RequestMapping("/ph_xg")
    public String phupdate(PolicyHolder policyholder, Model model) {
        int count = policyholderService.update(policyholder);
        return "ph_index";
    }

    //投保人批量删
//    @ResponseBody
//    @RequestMapping("ph_batchDelete")
//    public String csbatchDelete(String id) {
//        String[] id1 = id.split(",");
//        int count = policyholderService.batchDelete(id1);
//        if (count > 0) {
//            return "1";
//        }
//        return "0";
//    }

//       投保人查所有  分页
    @RequestMapping("ph_index")
    public String phfindAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        // 引入pagehelper插件
        // 传入页码,及每页条数
        PageHelper.startPage(pn, 6);
        // startPage后紧跟的查询就是分页查询
        List<PolicyHolder> list = policyholderService.findAll();
        // 使用pageInfo包装查询后的结果
        // 封装了分页的详情信息,和查询出来的结果
        PageInfo pageInfo = new PageInfo(list, 5);// 传入连续显示的页数
        model.addAttribute("pageInfo", pageInfo);
        return "sk_policyholder/policyholder";
    }

    // 多条件查询
//    @RequestMapping("/cs_cx")
//    public String csfindSelf(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Customer customer, Model model) {
//        // 引入pagehelper插件
//        // 传入页码,及每页条数
//        PageHelper.startPage(pn, 6);
//        // startPage后紧跟的查询就是分页查询
//        List<Customer> list = policyholderService.searchOne(customer);
//        // 使用pageInfo包装查询后的结果
//        // 封装了分页的详情信息,和查询来的结果
//        PageInfo pageInfo = new PageInfo(list, 5);// 传入连续显示的页数
//        model.addAttribute("pageInfo", pageInfo);
//        if(customer.getSerial()==""||(customer.getSite()==""&& customer.getMedicalrecord()=="")){
//          return "cs_index";
//       }
//        return "sk_customer/cx.jsp";
//    }
}
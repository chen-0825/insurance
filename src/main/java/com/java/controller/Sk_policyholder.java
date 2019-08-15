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
        return "redirect:ph_index";
    }

    //   投保人添加
    @RequestMapping("/ph_zj")
    public String phadd(PolicyHolder policyholder, Model model)  {
        int count = policyholderService.add(policyholder);
        return "redirect:ph_index";
    }

//    中转站
    @RequestMapping("/ph_zzz")
   public String phzzz(Model model){

       return "sk_policyholder/add";
   }


    //   投保人查单条
    @RequestMapping("/ph_findOne")
    public String phfindOne(PolicyHolder policyholder, Model model) {
        PolicyHolder p = policyholderService.findOne(policyholder);
        model.addAttribute("p", p);
        return "sk_policyholder/update";
    }


    //    投保人修改
    @RequestMapping("/ph_xg")
    public String phupdate(PolicyHolder policyholder, Model model) {
        int count = policyholderService.update(policyholder);
        System.out.println(policyholder);
        return "redirect:ph_index";
    }

    //投保人批量删
    @ResponseBody
    @RequestMapping("ph_batchDelete")
    public String phbatchDelete(String id) {
        String[] phId = id.split(",");
        int count = policyholderService.batchDelete(phId);
        if (count > 0) {
            return "1";
        }
        return "0";
    }

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
    @RequestMapping("/ph_cx")
    public String phfindSelf(@RequestParam(value = "pn", defaultValue = "1")  Integer pn, PolicyHolder policyholder, Model model) {
        // 引入pagehelper插件
        // 传入页码,及每页条数
        PageHelper.startPage(pn, 6);
        // startPage后紧跟的查询就是分页查询
        List<PolicyHolder> list = policyholderService.searchOne(policyholder);
        // 使用pageInfo包装查询后的结果
        // 封装了分页的详情信息,和查询来的结果
        PageInfo pageInfo = new PageInfo(list, 5);// 传入连续显示的页数
        model.addAttribute("pageInfo", pageInfo);
        if (policyholder.getPhName()=="" && policyholder.getPhCredNumber()==""){

            return "redirect:ph_index";

        }
        return "sk_policyholder/cx";
    }
}
package com.java.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.InsuredPerson;
import com.java.pojo.Survey;
import com.java.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

//    查所有分页
    @RequestMapping("/SurveyFindAll")
    public String SurveyFindAll(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        // 引入pagehelper插件
        // 传入页码,及每页条数
        PageHelper.startPage(pn, 1);
        // startPage后紧跟的查询就是分页查询
        List<Survey> list = surveyService.findAll();
        // 使用pageInfo包装查询后的结果
        // 封装了分页的详情信息,和查询出来的结果
        PageInfo pageInfo = new PageInfo(list, 3);// 传入连续显示的页数
        model.addAttribute("pageInfo", pageInfo);
        return "backstage/survey";
    }

}
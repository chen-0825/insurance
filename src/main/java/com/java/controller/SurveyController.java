package com.java.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.Lp;
import com.java.pojo.Survey;
import com.java.service.LpService;
import com.java.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class SurveyController {

    @Autowired
    private SurveyService surveyService;
    @Autowired
    private LpService lpService;

//    查所有分页
    @RequestMapping("/SurveyFindAll")
    public String SurveyFindAll(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        // 引入pagehelper插件
        // 传入页码,及每页条数
        PageHelper.startPage(pn, 8);
        // startPage后紧跟的查询就是分页查询
        List<Survey> list = surveyService.findAll();
        // 使用pageInfo包装查询后的结果
        // 封装了分页的详情信息,和查询出来的结果
        PageInfo pageInfo = new PageInfo(list, 3);// 传入连续显示的页数
        model.addAttribute("pageInfo", pageInfo);
        return "backstage/survey";
    }

//    修改状态
    @ResponseBody
    @RequestMapping("/Survey_status")
    public String Survey_status(Survey survey){
        int count = surveyService.update(survey);
        //根据状态在理赔信息中添加一条
        String dsStatus = survey.getDsStatus();
        if("通过".equals(dsStatus)){
            Survey one = surveyService.findOne(survey);
            Lp lp = new Lp();
            lp.setLpPeople(one.getName());
            lp.setLpMoney(one.getMoney());
            lp.setStatus("0");
            lp.setLpStatus("0");
            lp.setLpTime(new Date());
            lpService.insertLp(lp);
        }
        if(count>0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

//    删除
    @ResponseBody
    @RequestMapping("/Survey_delete")
    public void Survey_delete(String arr){
        String[] id = arr.split(",");
        surveyService.delete(id);
    }

    //增加
    @RequestMapping("/Survey_add")
    public String Survey_add(@RequestParam("file") MultipartFile file, Survey survey){
        String filename = file.getOriginalFilename();
        FileOutputStream fos = null;
        try {
            byte[] bytes = file.getBytes();
            fos = new FileOutputStream("D:\\idea\\workspace\\insurance\\src\\main\\resources\\static\\img\\"+filename);
            fos.write(bytes);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        survey.setPhoto(filename);
        surveyService.add(survey);
        return "redirect:SurveyFindAll";
    }

}
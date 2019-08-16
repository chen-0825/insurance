package com.java.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.Lpgl;
import com.java.pojo.Msg;
import com.java.service.LpglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LpglController {
    @Autowired
    private LpglService lpglService;

    //去界面
    @GetMapping("/lpgl")
    public String lpgl(){
        return "backstage/lpgl";
    }

    //分页查所有
    @GetMapping("/lpgls")
    @ResponseBody
    public Object lpgl(@RequestParam(value = "pn", defaultValue = "1")Integer pn){
        PageHelper.startPage(pn, 3);
        List<Lpgl> all = lpglService.findAll();
        for(Lpgl l:all){
            System.out.println(l);
        }
        if (all.size() == 0) {//如果查询结果没有,直接返回错误提示
            return Msg.fail();
        }
        PageInfo pageInfo = new PageInfo(all);
        return Msg.success().maps("page", pageInfo);
    }

    //删除单条
    @ResponseBody
    @DeleteMapping("/lpgl/{id}")
    public Msg deleteLpgl(@PathVariable("id") Integer id){
        int i = lpglService.deleteLpgl(id);
        if(i>0){
            return Msg.success();
        }
        return Msg.fail();
    }

    //批量删除
    @ResponseBody
    @DeleteMapping("/dels")
    public Msg deleteLpgls(String dels){
        //切割字符串
        String[] s = dels.split("_");
        List<Integer> list = new ArrayList<>();
        for (String ss:s){
            list.add(Integer.parseInt(ss));
        }
        int i = lpglService.deleteLpgls(list);
        if(i>0){
            return Msg.success();
        }
        return Msg.fail();
    }


}

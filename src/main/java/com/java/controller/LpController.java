package com.java.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.Lp;
import com.java.pojo.Msg;
import com.java.service.LpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LpController {
    @Autowired
    private LpService lpService;

    //去界面
    @GetMapping("/lpgl")
    public String lpgl() {
        return "backstage/lpgl";
    }

    //分页查所有,模糊排序查询
    @GetMapping("/lpgls")
    @ResponseBody
    public Msg lpgl(Lp lp, Integer id, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                    String ss, String sel, String sta) {
        if (ss != null && ss != "") {
            ss = "%" + ss + "%";
            lp.setLpPeople(ss);
        }
        lp.setStatus(sta);
        System.out.println(lp);

        Integer x = 3;
        if (sel != null && sel != "") {
            x = Integer.parseInt(sel);
        }

        PageHelper.startPage(pn, x);
        List<Lp> all = lpService.findLp(lp);
        for (Lp a: all){
            System.out.println(a);
        }
        if (all.size() == 0) {//如果查询结果没有,直接返回错误提示
            return Msg.fail();
        }
        PageInfo pageInfo = new PageInfo(all);
        return Msg.success().maps("page", pageInfo);
    }

    //修改理赔记录
    @ResponseBody
    @PutMapping("/updLpgl")
    public Object updLpgl(@Valid Lp lp, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        if(result.hasErrors()){
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError file:errors){
                map.put(file.getField(), file.getDefaultMessage());
            }
            return map;
        }else{
            int i = lpService.updateLp(lp);
            if (i > 0) {
                return Msg.success();
            }
            return Msg.fail();
        }
    }

    //查询指定记录
    @ResponseBody
    @GetMapping("/findLpgl/{id}")
    public Msg findLpgl(Lp lp, @PathVariable("id") Integer id) {
        List<Lp> by = lpService.findLp(lp);
        if (by.size() > 0) {
            return Msg.success().maps("lpgl", by.get(0));
        }
        return Msg.fail();
    }

}

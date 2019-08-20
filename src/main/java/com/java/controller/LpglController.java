package com.java.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.SnowFlake.Snowflake;
import com.java.pojo.Lpgl;
import com.java.pojo.Msg;
import com.java.service.LpglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LpglController {
    @Autowired
    private LpglService lpglService;

    //去界面
    @GetMapping("/lpgl")
    public String lpgl(){
        return "backstage/lpgl";
    }

    //分页查所有,模糊排序查询
    @GetMapping("/lpgls")
    @ResponseBody
    public Msg lpgl(Integer id, @RequestParam(value = "pn", defaultValue = "1")Integer pn, String ss, String desc, String ord){
        if(ss != null && ss != ""){
            ss = "%"+ss+"%";
        }

        System.out.println(desc);
        System.out.println(ss);
        System.out.println(ord);

        PageHelper.startPage(pn, 5);
        List<Lpgl> all = lpglService.findBy(id, ss, desc, ord);
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

    //增加理赔记录
    @ResponseBody
    @PostMapping("/insertLpgl")
    public Object insertLpgl(@Valid Lpgl lpgl, BindingResult result){
        if(result.hasErrors()){
            Map<Object, Object> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError f: fieldErrors){
                map.put(f.getField(), f.getDefaultMessage());
            }
            return map;
        }else{
            //雪花生成理赔编号
            Snowflake snowflake = new Snowflake(2,3);
            String l = snowflake.nextId()+"";
            lpgl.setLpId(l);
            int i = lpglService.insertLpgl(lpgl);
            if(i > 0){
                return Msg.success();
            }
            return Msg.fail();
        }
    }

    //修改理赔记录
    @ResponseBody
    @PutMapping("/updLpgl")
    public Object updLpgl(@Valid Lpgl lpgl, BindingResult result){
        if(result.hasErrors()){
            Map<Object, Object> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError f: fieldErrors){
                map.put(f.getField(), f.getDefaultMessage());
            }
            return map;
        }else{
            int i = lpglService.updateLpgl(lpgl);
            if(i > 0){
                return Msg.success();
            }
            return Msg.fail();
        }
    }

    //查询指定记录
    @ResponseBody
    @GetMapping("/findLpgl/{id}")
    public Msg findLpgl(@PathVariable("id")Integer id){
        List<Lpgl> by = lpglService.findBy(id,"","","");
        if(by.size() > 0){
            return Msg.success().maps("lpgl", by.get(0));
        }
        return Msg.fail();
    }

}

package com.java.controller.guarantee;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.Msg;
import com.java.pojo.Policys;
import com.java.service.guaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zl
 * @create 2019-08-11 19:32
 */
@Controller
public class guarantee {

    @Autowired
    private guaranteeService guaranteeservice;


    //进入保单页面
    @GetMapping("/guarantees")
    @ResponseBody
    public Msg showGuarantee(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        //在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 8);
        List<Policys> policysList = guaranteeservice.guaranteesfindAll();
        //封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数5
        PageInfo page = new PageInfo(policysList,5);
        return Msg.success().maps("pageInfo", page);
    }

    //添加保单
    @RequestMapping(value="guarantee/insert",method = RequestMethod.POST)
    public Msg insert(HttpServletRequest request){
//        String plate_number = request.getParameter("plate_number");
//        String vin = request.getParameter("vin");
        String startDate = request.getParameter("start_date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//      String time = sdf.format(startDate);
        Date times = null;
        try {
            //强转日期格式
            times = sdf.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Policys po = new Policys("3","2",times,
                times,times,22.2,
                "新保", "保期内",500000.9,"3",
                "4","5","6","红色","轿车",
                7,"8","2",200000.9,
                times,5,5555.5);
        int i = guaranteeservice.guaranteeinsert(po);
        return Msg.success();
    }


    //单条删除
    @ResponseBody
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public Msg delete(@PathVariable("id")String policyId){
        guaranteeservice.guaranteedelete(policyId);
        return Msg.success();
    }
}

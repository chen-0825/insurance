package com.java.controller.guarantee;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.Msg;
import com.java.pojo.Policys;
import com.java.service.guaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
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

//    @RequestMapping("/emps")
//    @ResponseBody
//    public Msg getEmpsWithJson(
//            @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
//        // 这不是一个分页查询
//        // 引入PageHelper分页插件
//        // 在查询之前只需要调用，传入页码，以及每页的大小
//        PageHelper.startPage(pn, 5);
//        // startPage后面紧跟的这个查询就是一个分页查询
//        List<Employee> emps = employeeService.getAll();
//        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
//        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
//        PageInfo page = new PageInfo(emps, 5);
//        return Msg.success().add("pageInfo", page);
//    }

    //进入保单页面
    @RequestMapping("guarantee")
    @ResponseBody
    public Msg showGuarantee(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        List<Policys> policysList = guaranteeservice.guaranteesfindAll();
        PageHelper.startPage(pn, 8);
        PageInfo page = new PageInfo(policysList, 5);
        return Msg.success().maps("pageInfo", page);
//        return "guarantee/guarantee";
    }

    //添加保单
    @RequestMapping(value="guarantee/insert",method = RequestMethod.POST)
    public Msg insert(HttpServletRequest request){
        String plate_number = request.getParameter("plate_number");
        String vin = request.getParameter("vin");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);
        ParsePosition pos = new ParsePosition(0);
        Date times = sdf.parse(time, pos);
        Policys po = new Policys("1","2",times,
                times,times,22.2,
                "新保", "保期内",500000.9,"3",
                "4","5","6","红色","轿车",
                7,"8","2",200000.9,
                times,5,5555.5);
            int i = guaranteeservice.guaranteeinsert(po);
        return Msg.success();
    }
}

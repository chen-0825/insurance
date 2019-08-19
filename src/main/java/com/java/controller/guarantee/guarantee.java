package com.java.controller.guarantee;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.SnowFlake.Snowflake;
import com.java.pojo.Msg;
import com.java.pojo.Policys;
import com.java.service.guaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zl
 * @create 2019-08-11 19:32
 */
@Controller
public class guarantee {

    @Autowired
    private guaranteeService guaranteeservice;

    List<Policys> tiaojianfind = null;

    Policys po = new Policys();

    //进入保单页面
    @ResponseBody
    @RequestMapping("/guarantees")
    public Msg showGuarantee(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        PageHelper.startPage(pn, 8);
        PageInfo page = null;
        if (tiaojianfind == null){
            //在查询之前只需要调用，传入页码，以及每页的大小

            List<Policys> policysList = guaranteeservice.guaranteesfindAll();
            //封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数5
            page = new PageInfo(policysList,5);
            return Msg.success().maps("pageInfo", page);
        }else {
            //查询相同的被保人没有分页？
            page = new PageInfo(tiaojianfind,5);
            return Msg.success().maps("pageInfo", page);
        }

    }

    //在第二个模态框点击下一步生成保单号传给第三个模态框
    @ResponseBody
    @RequestMapping(value="policyId",method = RequestMethod.POST)
    public String show(){
        /*雪花算法生成serial*/
        Snowflake snowFlake = new Snowflake(2, 3);
        String serial = Long.toString(snowFlake.nextId());
        return serial;
    }


    //添加保单
    @ResponseBody
    @RequestMapping(value="guarantee/insert",method = RequestMethod.POST)
    public Msg insert(HttpServletRequest request){
        String plate_number = request.getParameter("plate_number");
        String vin = request.getParameter("vin");
        String driving_Licence = request.getParameter("driving_Licence");
        String factory_plate_model = request.getParameter("factory_plate_model");
        String date_of_registration = request.getParameter("date_of_registration");
        String engine = request.getParameter("engine");
        String passenger_number = request.getParameter("passenger_number");
        String name_of_owner = request.getParameter("name_of_owner");
        String useful_year = request.getParameter("useful_year");
        String driving_mileage = request.getParameter("driving_mileage");
        String vehicles_type = request.getParameter("vehicles_type");
        String car_price = request.getParameter("car_price");
        String written_date = request.getParameter("written_date");
        String start_date = request.getParameter("start_date");
        String ending_date = request.getParameter("ending_date");
        String policy_type = request.getParameter("policy_type");
        String recognizee = request.getParameter("recognizee");
        String baofeizonge = request.getParameter("baofeizonge");
        String peichangxiane = request.getParameter("peichangxiane");
        String policy_id = request.getParameter("policy_id");
        String idcard = request.getParameter("idcard");
        String color = request.getParameter("color");
        String policyState = "保期内";

        Double baofei = Double.parseDouble(baofeizonge);
        Double xiane = Double.parseDouble(peichangxiane);
        Double price = Double.parseDouble(car_price);
        Double mileage = Double.parseDouble(driving_mileage);
        int number = Integer.parseInt(passenger_number);
        int year = Integer.parseInt(useful_year);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date writtendate = null;
        Date startdate = null;
        Date endingdate = null;
        Date dateofregistration = null;
        try {
            //强转日期格式
            writtendate = sdf.parse(written_date);
            startdate = sdf.parse(start_date);
            endingdate = sdf.parse(ending_date);
            dateofregistration = sdf.parse(date_of_registration);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Policys po = new Policys(policy_id,recognizee,writtendate,
                startdate,endingdate,baofei,
                policy_type, policyState,xiane,engine,
                vin,factory_plate_model,plate_number,color,vehicles_type,
                number,driving_Licence,name_of_owner,price,
                dateofregistration,year,mileage,idcard);
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

    //条件查询
    @ResponseBody
    @RequestMapping(value="find",method = RequestMethod.POST)
    public ModelAndView find(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String policyId = request.getParameter("policyId");
        String recognizee = request.getParameter("recognizee");
        String vin = request.getParameter("vin");
        String plateNumber = request.getParameter("plateNumber");


        po.setPolicyId(policyId);
        po.setRecognizee(recognizee);
        po.setVin(vin);
        po.setPlateNumber(plateNumber);
        tiaojianfind = guaranteeservice.tiaojianfind(po);
        mv.setViewName("redirect:/guarantees");
        return mv;
    }

    //模态框1 303校验
    @RequestMapping(value="check",method=RequestMethod.POST)
    @ResponseBody
    //支持JSR303校验在校验的类加上@Valid和类Errors或BindingResult
    public Msg saveEmp(@Valid Policys po, BindingResult result){
        if(result.hasErrors()){
            //校验失败，应该返回失败，在模态框中显示校验失败的错误信息
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名："+fieldError.getField());
                System.out.println("错误信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().maps("errorFields", map);
        }
        else{
//            employeeService.saveEmp(employee);
            return Msg.success();
        }

    }

    //查单条显示在修改框
    @RequestMapping(value="/bianxie/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id")String id){
        po.setPolicyId(id);
        guaranteeservice.tiaojianfind(po);
        return Msg.success().maps("po", po);
    }
}

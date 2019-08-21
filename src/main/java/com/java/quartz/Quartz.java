package com.java.quartz;

import com.java.pojo.ExpirationInfo;
import com.java.service.QuartMissionService;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
public class Quartz {
    @Autowired
    private QuartMissionService quartMissionService;

    //任务调度每天早上9点执行
//    @Scheduled(cron = "0 0 12 * * ?")
    @Scheduled(cron = "0 38 8 * * ?")
    public void snedToSevenDays(){
        //获取7天后的日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        LocalDate sourceDate = LocalDate.parse(format, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String nextDay = String.valueOf(sourceDate.plusDays(10));
        System.out.println(nextDay);
        List<ExpirationInfo> endingList = quartMissionService.findSevenDaysToEnding(nextDay);
        System.out.println(endingList.toString());
        for (ExpirationInfo e:
                endingList) {
            ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com","102119","4adf806b-4efd-4959-8894-b46be4ddb9af");
            try {
                client.send(e.getIptel(),"亲爱的车主"+e.getIpname()+"您好,您车牌号为"+e.getPlatenumber()+"的车险,将于"+e.getEndingdate()+"到期,请到线下门店续保,可拨打400-921-5105咨询详情.");
            } catch (Exception ex) {
                continue;
            }
        }
    }

    //任务调度每月最后一天
    @Scheduled(cron = "0 0 12 1 * ?")
    public void sendToNextMonth(){
        //获取7天后的日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        LocalDate sourceDate = LocalDate.parse(format, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String next = String.valueOf(sourceDate.plusMonths(1));
        String nextMonths = next.substring(0, 7)+"%";
        List<ExpirationInfo> expirationInfos = quartMissionService.sendToNextMonth(nextMonths);

        for (ExpirationInfo e:
                expirationInfos) {
            ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com","102119","4adf806b-4efd-4959-8894-b46be4ddb9af");
            try {
                client.send(e.getIptel(),"亲爱的车主"+e.getIpname()+"您好,您车牌号为"+e.getPlatenumber()+"的车险,将于"+e.getEndingdate()+"到期,请到线下门店续保,可拨打400-921-5105咨询详情.");
            } catch (Exception ex) {
                continue;
            }
        }
    }


}

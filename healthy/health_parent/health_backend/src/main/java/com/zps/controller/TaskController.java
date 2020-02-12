package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.entity.Result;
import com.zps.pojo.OrderSetting;
import com.zps.service.OrderSettingService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by zps on 2019/12/23 20:39
 */
@Component
@RestController
@EnableScheduling//开启对计划任务的支持
@Lazy(value = false) //代表延时加载
@RequestMapping("/task")
public class TaskController implements SchedulingConfigurer {
    //日期格式化
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    //定义要存储数据的集合
    private List<OrderSetting> dataList = new ArrayList<>();

    @Reference
    private OrderSettingService orderSettingService;
    public static String cron = "* 0/1 * * * ?";
    private static String number = "300";
    private static String day = "25";


    @RequestMapping("/test")
    public Result test(String days, String numbers, String month, String hour, String minute, String second) {
        number = numbers;
        day = days;
        String setCron = second + " " + minute + " " + hour + " " + days + " " + month + " ?";
        System.out.println(setCron);
        System.out.println("cron 设置为:" + setCron);
        cron = setCron;
        System.err.println("cron change to:" + cron);
        return new Result(true, "设置成功");

    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegister) {
        taskRegister.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 逻辑任务
                try {
                    System.out.println("到时候了");
//                    List<String> list = DateUtil(Integer.parseInt(day)-1);
//                    for (String s : list) {
//                        Document doc = Jsoup.connect("http://www.easybots.cn/api/holiday.php?d=" + s).ignoreContentType(true).userAgent("Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15)").timeout(5000).get();
//                        String body = doc.getElementsByTag("body").html();
//                        char c = body.split(";")[body.split(";").length - 2].charAt(0);
//                        if (c == '0') { //上班
//                            dataList.add(new OrderSetting(sdf2.parse(s), Integer.parseInt(number)));
//                        } else {
//                            dataList.add(new OrderSetting(sdf2.parse(s), 0));
//                        }
//                    }
//                    System.out.println("保存成功" + dataList);
//                    orderSettingService.add(dataList);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 任务触发，可修改任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                System.out.println("cron表达式:" + cron);
                Date nextExecutor = trigger.nextExecutionTime(triggerContext);
                return nextExecutor;
            }
        });
    }

    //根据传递的天数，得到从该日期到下一个月的前一天日期的集合
    public static List<String> DateUtil(Integer days) throws Exception {
        List<String> list = new ArrayList<>();
        Date date = new Date();
        String format = sdf.format(date);
        Calendar c = Calendar.getInstance();
        String start = format + "-" + days;
        Date parse = sdf2.parse(start);
        c.setTime(parse);
        int index = 0;
        for (int i = 0; i <= 36; i++) {
            int day = c.get(Calendar.DATE);
            c.add(Calendar.DATE, 1);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH) + 1;
            int day2 = c.get(Calendar.DATE);
            String MM = month + "";
            String dd = day2 + "";
            //优化月份跟日可能会是单数的情况
            if (month < 10) {
                MM = "0" + MM;
            }
            if (day2 < 10) {
                dd = "0" + dd;
            }

            list.add(year + "-" + MM + "-" + dd);
            if (day2 == days) {
                break;
            }
        }
        return list;
    }

    //测试方法
    public static void main(String[] args) throws Exception {
        List<String> list = DateUtil(23);
        System.out.println(list);
        //2节假日
        //http://www.easybots.cn/api/holiday.php?d=2019-10-03
        Document doc = Jsoup.connect("http://www.easybots.cn/api/holiday.php?d=2019-12-24").ignoreContentType(true).userAgent("Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15)").timeout(5000).get();
        System.out.println(doc);
        String body = doc.getElementsByTag("body").html();
        char c = body.split(";")[body.split(";").length - 2].charAt(0);
        System.out.println(c);

    }

}

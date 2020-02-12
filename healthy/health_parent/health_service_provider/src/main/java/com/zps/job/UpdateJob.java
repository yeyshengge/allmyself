/*
package com.zps.job;


import com.zps.dao.UpdateDao;
import com.zps.pojo.OrderSetting;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

*/
/**
 * Created by zps on 2019/12/23 20:59
 *//*

@Component
public class UpdateJob {
    //记录真日期
    private String flag = "1";
    //记录人数
    private String flag2 = "300";
    private String flag3 = "2019-12-15";
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private UpdateDao updateDao;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

    @Scheduled()
    public void test() throws Exception {

        System.out.println(new Date());

      */
/*  List<OrderSetting> list = new ArrayList<>();
        String number = jedisPool.getResource().hget("updatemap", "number");
        String day = jedisPool.getResource().hget("updatemap", "jobTime");
        String date = sdf.format(new Date());
        //这个月设置的时间（大于）
        Date sDate = sdf2.parse(date + "-" + day);
        //设置的天数是否大于flag
        if (Integer.parseInt(day) >= Integer.parseInt(flag)) {
            if (new Date().getTime() > sDate.getTime()) {
                //执行方法
                List<String> list1 = DateUtil(Integer.parseInt(day));
                for (String s : list1) {
                    Date parse = sdf2.parse(s);
                    String jsonResult = request(s);
                    // 0 上班  1周末 2节假日
                    if ("0".equals(jsonResult)) {
                        list.add(new OrderSetting(parse, Integer.parseInt(number)));
                    }
                    if ("1".equals(jsonResult)) {
                        list.add(new OrderSetting(parse, 0));
                    }
                    if ("2".equals(jsonResult)) {
                        list.add(new OrderSetting(parse, 0));
                    }
                }

                System.out.println("保存中" + list);
                if (list.size() != 0) {
                    updateDao.updateJob(list);
                }
                flag = 100 + "";
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //判断是否是月末
        if (calendar.get(Calendar.DAY_OF_MONTH) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            flag = "0";
        }*//*



    }

    @Test
    public void annotionTest() throws Exception {


        UpdateJob updateJob = new UpdateJob();
        Method method = updateJob.getClass().getDeclaredMethod("test");
        Scheduled scheduled = method.getAnnotation(Scheduled.class);
        String cron = scheduled.cron();
        System.out.println(cron);
        InvocationHandler h = Proxy.getInvocationHandler(scheduled);
        Field hFiled = h.getClass().getDeclaredField("memberValues");
        hFiled.setAccessible(true);
        Map memberValues = (Map) hFiled.get(h);
        memberValues.put("cron","* * * * * ?");


    }

    public List<String> DateUtil(Integer days) throws Exception {
        List<String> list = new ArrayList<>();
        Date date = new Date();
        String format = sdf.format(date);
        Calendar c = Calendar.getInstance();
        String start = format + "-" + days;
        Date parse = sdf2.parse(start);
        c.setTime(parse);
        for (int i = 0; i <= 32; i++) {
            int day = c.get(Calendar.DATE);
            c.add(Calendar.DATE, 1);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH) + 1;
            int day2 = c.get(Calendar.DATE);
            if (day2 == days) {
                break;
            }
            list.add(year + "-" + month + "-" + day);
        }
        return list;
    }


    public static String request(String httpArg) {
        String httpUrl = "http://tool.bitefu.net/jiari/";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?d=" + httpArg;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        // 处理节假日
        String httpArg = "2019-12-30";
        String jsonResult = request(httpArg);
        System.out.println(jsonResult);
        // 0 上班  1周末 2节假日
        if ("0".equals(jsonResult)) {
            //return resultObject.getFailResult("上班");
            System.out.println("0上班");
        }
        if ("1".equals(jsonResult)) {
            //return resultObject.getFailResult("1周末");
            System.out.println("1周末");
        }
        if ("2".equals(jsonResult)) {
            //return resultObject.getFailResult("");
            System.out.println("2节假日");
        }
    }

}
*/

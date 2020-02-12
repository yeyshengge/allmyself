package com.zps.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by zps on 2019/12/19 15:39
 */
@Component
public class Job {

    @Scheduled(cron = "0/5 * * * * ?")
    public void test() {
        System.out.println("aaa");
    }

}

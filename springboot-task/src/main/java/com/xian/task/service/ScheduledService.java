package com.xian.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    /**
     * second,minute,hour,day of month,month, day of week
     * 0 * * * * MON-FRI
     */
    //@Scheduled(cron = "0 * * * * MON-SAT")
    //@Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
//    @Scheduled(cron = "0-4 * * * * MON-SAT")
    @Scheduled(cron = "0/4 * * * * MON-SAT")   //每四秒执行一次
    public void hello() {
        System.out.println("hello...");
    }

}

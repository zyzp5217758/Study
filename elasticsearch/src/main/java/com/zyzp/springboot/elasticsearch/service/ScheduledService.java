package com.zyzp.springboot.elasticsearch.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    int i = 0;
    @Scheduled(cron = "0-4 07 21 * * *")
    public void scheduledTask(){
        System.out.println("hello"+i++);
    }

    @Async
    public void testSync(){
        try {
            Thread.sleep(300000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello，我已经完成了");
    }
}

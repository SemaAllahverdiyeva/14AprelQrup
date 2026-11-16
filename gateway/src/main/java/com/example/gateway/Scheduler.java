package com.example.gateway;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(cron = "0 0 9 * * *", zone = "Asia/Baku")
    public void runDaily() {

        System.out.println("Scheduler is working!");
        System.out.println("Every day at 09:00 (Baku time)");

    }

}

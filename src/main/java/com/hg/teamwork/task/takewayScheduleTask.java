package com.hg.teamwork.task;

import com.hg.teamwork.model.Takeway;
import com.hg.teamwork.server.TakewayServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.Random;

@Configuration
@EnableScheduling
public class takewayScheduleTask {

    @Autowired
    TakewayServer takewayServer;

    @Scheduled(cron = "0 0 11 * * ? ")
    private void configureTasks() {
        int a = new Random().nextInt(10000);
        int b = new Random().nextInt(10000);
        int c = new Random().nextInt(10000);
        while (a == b || a == c || b == c) {
            a = new Random().nextInt(10000);
            b = new Random().nextInt(10000);
            c = new Random().nextInt(10000);
        }

        Takeway takeway = new Takeway();
        takeway.setTime(new Date());
        if ((a > b) && (a > c)) {
            takeway.setName("应");
        }

        if ((b > a) && (b > c)) {
            takeway.setName("张");
        }

        if ((c > a) && (c > b)) {
            takeway.setName("丁");
        }

        takewayServer.insert(takeway);
    }

}

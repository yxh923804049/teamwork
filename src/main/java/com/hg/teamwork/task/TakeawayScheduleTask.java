package com.hg.teamwork.task;

import com.hg.teamwork.model.Takeaway;
import com.hg.teamwork.service.TakeawayService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

/**
 * @author ying
 * @describe 定时任务每天早上11点执行
 * @date 2021/06/02
 */
@Configuration
@EnableScheduling
public class TakeawayScheduleTask {

    @Resource
    TakeawayService takeawayServer;

    @Scheduled(cron = "0 0 11 ? * MON-FRI")
    private void configureTasks() {
        int a = new Random().nextInt(10000);
        int b = new Random().nextInt(10000);
        int c = new Random().nextInt(10000);
        while (a == b || a == c || b == c) {
            a = new Random().nextInt(10000);
            b = new Random().nextInt(10000);
            c = new Random().nextInt(10000);
        }

        Takeaway takeaway = new Takeaway();
        takeaway.setTime(new Date());
        if ((a > b) && (a > c)) {
            takeaway.setName("应");
        }

        if ((b > a) && (b > c)) {
            takeaway.setName("张");
        }

        if ((c > a) && (c > b)) {
            takeaway.setName("丁");
        }

        takeawayServer.takeawayInsert(takeaway);
    }

}

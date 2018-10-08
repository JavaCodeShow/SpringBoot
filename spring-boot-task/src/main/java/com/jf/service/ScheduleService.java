package com.jf.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author 潇潇暮雨
 * @create 2018-10-08   15:12
 */
@Service
public class ScheduleService {

    @Scheduled(cron = "0-59 * * * * MON-FRI")
    public void scheduled(){
        System.out.println("定时任务执行");
    }
}

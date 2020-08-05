package io.renren.modules.jingdong.controller;

import com.jd.open.api.sdk.JdException;
import io.renren.modules.jingdong.service.CrawlingActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class CrawlingAct {
    @Autowired
    private CrawlingActService service;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //每隔10分钟爬取一次
    @Scheduled(fixedRate = 600000)
    public void testTasks() throws JdException, ParseException, IOException {
        System.out.println("活动定时任务执行时间：" + dateFormat.format(new Date()));
        service.batchCrawlerAllProduct();

    }




}

package io.renren.modules.jingdong.controller;

import com.jd.open.api.sdk.JdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler{
    @Autowired
    private JdController jdController;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //每隔10分钟秒执行一次
    @Scheduled(fixedRate = 1200000)
    public void testTasks() throws JdException, ParseException {
        System.out.println("订单定时任务执行时间：" + dateFormat.format(new Date()));

        List<String> timeList = getCurrentTime();
        for (int i =0 ;i<timeList.size();i++){
            jdController.operationData(timeList.get(i));
        }
    }

    /**
     * 获取当前时间前5分钟
     * @return
     */
    public List<String> getCurrentTime(){
        List<String>timeList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        for (int i = -15; i < 1; i++) {
            Calendar beforeTime = Calendar.getInstance();
            beforeTime.add(Calendar.MINUTE, i);// 3分钟之前的时间
            Date beforeD = beforeTime.getTime();
            String time = sdf.format(beforeD);
            timeList.add(time);
        }
        return timeList;
    }


}

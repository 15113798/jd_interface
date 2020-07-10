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

    //每隔480秒执行一次
    @Scheduled(fixedRate = 480000)
    public void testTasks() throws JdException, ParseException {
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));

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
        Calendar beforeTime = Calendar.getInstance();
        for (int i = -10;i<0;i++){
            beforeTime.add(Calendar.MINUTE, i);// 5分钟之前的时间
            Date beforeD = beforeTime.getTime();
            String time = sdf.format(beforeD);
            timeList.add(time);
        }
        return timeList;
    }


}

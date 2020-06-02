package io.renren.modules.taobao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jd.open.api.sdk.JdException;
import io.renren.modules.jingdong.controller.JdController;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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
public class TaoBaoScheduler {


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    //每隔5分钟执行一次
    @Scheduled(fixedRate = 120000)
    public void testTasks() throws IOException {

        //开始爬取活动列表
        //startActCrawler();

        //开始爬取服务订单列表
        //startOrderCrawler();

    }
/*

    public static void main(String[] args) throws IOException {
        startCrawler();
    }
*/


    public  void startOrderCrawler() throws IOException {

        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
        HttpClient httpClient = HttpClients.createDefault();

        //HttpGet httpGet = new HttpGet("https://pub.alimama.com/cp/event/list.json?toPage=3&perPageSize=40&sceneId=6&t=1588337681798&_tb_token_=7e6ee4383ee0e&pvid=");
        HttpGet httpGet = new HttpGet("https://pub.alimama.com/report/getCPPaymentDetails.json?t=1588342550342&_tb_token_=7e6ee4383ee0e&startTime=2020-04-25&endTime=2020-05-01&payStatus=&queryType=1&toPage=1&perPageSize=40&jumpType=0");
        httpGet.setHeader("cookie", "t=c6246023665521e6fa92ca27110bae2e;cna=zzmmf4qsg1mcaxh2mh5w5vsm;cookie2=12710dcc61de09fd861f904305b75a48;_tb_token_=7e6ee4383ee0e;jsessionid=c852424e90afc17e8c282f4a64f50a3d;account-path-guide-s1=true;_m_h5_c=62295299247865c043c63fa3736e490f_1588332330033%3b55b4af24b6e85b5549c21804316ade3d;v=0;alimamapwag=tw96awxsys81ljagkfdpbmrvd3mgtlqgmtaumdsgv09xnjqpiefwcgxlv2vis2l0lzuzny4zniaos0hutuwsigxpa2ugr2vja28pienocm9tzs82os4wljm0otcumtawifnhzmfyas81mzcumzy%3d;cookie32=73b54f2902379700926005ff2249e7e1;alimamapw=rlyca1acblylcdpvafdruwvubqrvalmlaqduavbwagbwb1vua1idbgbxuq%3d%3d;cookie31=mtmznza5odu3lhrintq0mduyotksntqzmdk5ntyyqhfxlmnvbsxuqg%3d%3d;login=v32fpkk%2fw0duvg%3d%3d;l=ebqvkuuuq2tqewjabo5z-urza77teidfh-fzanbmiihca1dlg9y5onqcvzbppdtxgt5a7etr4e-prrnk5dau-xa8tih5haaoo3pw7e1..;isg=bejcltcpqle0lrte-a2ukwmkk0ike0yto8pxi4xaplql3-rzdkhopanzj9uj3b7f");

        HttpResponse response = httpClient.execute(httpGet);

        String contents = EntityUtils.toString(response.getEntity(),"gbk");//utf-8

        JSONObject jsonObject = JSON.parseObject(contents);
        JSONObject dataObject = jsonObject.getJSONObject("data");
        JSONArray list = dataObject.getJSONArray("result");
        for (int i = 0; i < list.size(); i++) {
            JSONObject news = list.getJSONObject(i);
            String title = news.getString("title");
            System.out.println(title);
        }
    }



    public  void startActCrawler() throws IOException {

        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("https://pub.alimama.com/cp/event/list.json?toPage=3&perPageSize=40&sceneId=6&t=1588337681798&_tb_token_=7e6ee4383ee0e&pvid=");
        //HttpGet httpGet = new HttpGet("https://pub.alimama.com/report/getCPPaymentDetails.json?t=1588342550342&_tb_token_=7e6ee4383ee0e&startTime=2020-04-25&endTime=2020-05-01&payStatus=&queryType=1&toPage=1&perPageSize=40&jumpType=0");
        httpGet.setHeader("cookie", "t=c6246023665521e6fa92ca27110bae2e;cna=zzmmf4qsg1mcaxh2mh5w5vsm;cookie2=12710dcc61de09fd861f904305b75a48;_tb_token_=7e6ee4383ee0e;jsessionid=c852424e90afc17e8c282f4a64f50a3d;account-path-guide-s1=true;_m_h5_c=62295299247865c043c63fa3736e490f_1588332330033%3b55b4af24b6e85b5549c21804316ade3d;v=0;alimamapwag=tw96awxsys81ljagkfdpbmrvd3mgtlqgmtaumdsgv09xnjqpiefwcgxlv2vis2l0lzuzny4zniaos0hutuwsigxpa2ugr2vja28pienocm9tzs82os4wljm0otcumtawifnhzmfyas81mzcumzy%3d;cookie32=73b54f2902379700926005ff2249e7e1;alimamapw=rlyca1acblylcdpvafdruwvubqrvalmlaqduavbwagbwb1vua1idbgbxuq%3d%3d;cookie31=mtmznza5odu3lhrintq0mduyotksntqzmdk5ntyyqhfxlmnvbsxuqg%3d%3d;login=v32fpkk%2fw0duvg%3d%3d;l=ebqvkuuuq2tqewjabo5z-urza77teidfh-fzanbmiihca1dlg9y5onqcvzbppdtxgt5a7etr4e-prrnk5dau-xa8tih5haaoo3pw7e1..;isg=bejcltcpqle0lrte-a2ukwmkk0ike0yto8pxi4xaplql3-rzdkhopanzj9uj3b7f");

        HttpResponse response = httpClient.execute(httpGet);

        String contents = EntityUtils.toString(response.getEntity(),"gbk");//utf-8

        JSONObject jsonObject = JSON.parseObject(contents);
        JSONObject dataObject = jsonObject.getJSONObject("data");
        JSONArray list = dataObject.getJSONArray("result");
        for (int i = 0; i < list.size(); i++) {
            JSONObject news = list.getJSONObject(i);
            String title = news.getString("title");
            System.out.println(title);
        }

    }



}

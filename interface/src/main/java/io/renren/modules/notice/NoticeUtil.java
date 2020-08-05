package io.renren.modules.notice;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class NoticeUtil {
    public static String url = "http://sms10692.com/sms.aspx";
    public static String userid = "8820";
    public static String account = "user810";
    public static String password = "aa123456";
    public static String mobile ="18692274262";


    public static void sendSms(String mobile,String content) throws IOException {
        content = URLEncoder.encode(content,"utf-8");
        //传递参数
        String param = "action=send"+"&userid="+userid+"&account="+account+"&password="+password+"&mobile="+mobile+"&content="+content;//参数根据实际情况拼装
        System.out.println(param);
        HttpClient httpClient = new HttpClient();
        HttpMethod get = new GetMethod(url+"?"+param);  //get请求方式
        get.releaseConnection();
        httpClient.executeMethod(get);//发送
        String response = get.getResponseBodyAsString();  //取得返回结果
        System.out.println(response);


    }


}

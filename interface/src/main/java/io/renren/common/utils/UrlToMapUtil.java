package io.renren.common.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class UrlToMapUtil {

    public static Map getUrlParams(String url){
        Map<String,Object> map = new HashMap<>();
        url = url.replace("?",";");
        if (!url.contains(";")){
            return map;
        }
        if (url.split(";").length > 0){
            String[] arr = url.split(";")[1].split("&");
            for (String s : arr){
                String key = s.split("=")[0];
                String value = s.split("=")[1];
                map.put(key,value);
            }
            return  map;

        }else{
            return map;
        }
    }
}

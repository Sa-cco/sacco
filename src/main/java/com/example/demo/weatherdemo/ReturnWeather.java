package com.example.demo.weatherdemo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Vector;

@Component
public class ReturnWeather {

    private JsonNode json=null;
    private final String uri="https://www.sojson.com/open/api/weather/json.shtml?city=";
    private boolean getJsonData(String city){
        System.out.println("getJsonData中的city：=");
        //请求第三方数据
        RestTemplate rest=new RestTemplate();
        //ResponseEntity<T>是Spring对HTTP请求响应的封装
        //包括了几个重要的元素，如响应码、contentType、contentLength、响应消息体等，
        //String.class,表示希望返回的body类型是String
        ResponseEntity<String> response=rest.getForEntity(uri+city,String.class);

        //查询为成功的状态码
        if(response.getStatusCodeValue()==200){
            String strBody=response.getBody();
            ObjectMapper mapper=new ObjectMapper();
            try{
                json=mapper.readTree(strBody);
                return true;
            }catch (IOException e){
                System.out.println("json初始化失败");
                e.printStackTrace();
            }
        }
        return false;
    }

    public todayweather gettodayweather(String city){
        if(json==null){
            boolean judge=getJsonData(city);
            if (judge==false)return null;
        }
        todayweather result=new todayweather();
        try{
            JsonNode data=json.get("data");
            result.setShidu(data.get("shidu").toString());
            result.setGanmao(data.get("ganmao").toString());
            result.setPm10(data.get("pm10").toString());
            result.setPm25(data.get("pm25").toString());
            result.setQuality(data.get("quality").toString());
            result.setWendu(data.get("wendu").toString());
        }catch (Exception e){
            System.out.println("获取当前天气状况失败");
            e.printStackTrace();
            return null;
        }
        return result;
    }

    private Weather returnwth(JsonNode deal) throws Exception{
        Weather result=new Weather();
        result.setApi(deal.get("aqi").toString());
        result.setDate(deal.get("date").toString());
        result.setFl(deal.get("fl").toString());
        result.setFx(deal.get("fx").toString());
        result.setHigh(deal.get("high").toString());
        result.setLow(deal.get("low").toString());
        result.setNotice(deal.get("notice").toString());
        result.setSunrise(deal.get("sunrise").toString());
        result.setSunset(deal.get("sunset").toString());
        result.setType(deal.get("type").toString());
        return result;
    }

    public Vector<Weather> getweatherList(String city){
        if(json ==null){
            boolean judge=getJsonData(city);
            if (judge==false)return null;
        }
        Vector<Weather> result=new Vector<Weather>();
        try {
            JsonNode yd = json.get("data").get("yesterday");
            Weather yesterday = returnwth(yd);
            Weather forecast;
            result.add(yesterday);
            JsonNode fc = json.get("data").get("forecast");
            for (int i = 0; i < 5; i++) {
                forecast = returnwth(fc.get(i));

            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return result;
    }

}

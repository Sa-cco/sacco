package com.example.demo.weatherdemo1;

import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;


@Component
public class WeatherJsonUtil {
    /**
     * 获取实时天气1<br></>
     *
     *
     * @param cityId
     *          城市编码
     */

    public static Map<String,Object> getTodayWeather1(String cityId)throws IOException,NullPointerException{
        //连接中央气象台的API
        URL url =new URL("http://www.weather.com.cn/data/sk/"+cityId+".html");
        URLConnection connectionData=url.openConnection();
        connectionData.setConnectTimeout(1000);
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(
                    connectionData.getInputStream(),"UTF-8"
            ));
            StringBuffer sb=new StringBuffer();
            String line =null;
            while((line=br.readLine())!=null){
                sb.append(line);
                String datas=sb.toString();
                System.out.println("输出1的结果："+datas);
                JSONObject jsonData = JSONObject.fromObject(datas);
                JSONObject info = jsonData.getJSONObject("weatherinfo");
                map.put("city", info.getString("city").toString());// 城市
                map.put("temp", info.getString("temp").toString());// 温度
                map.put("WD", info.getString("WD").toString());// 风向
                map.put("WS", info.getString("WS").toString());// 风速
                map.put("SD", info.getString("SD").toString());// 湿度
                map.put("time", info.getString("time").toString());// 发布时间

            }
        }catch (SocketTimeoutException e){
            System.out.println("连接超时");
        }catch (FileNotFoundException e){
            System.out.println("加载文件出错");
        }
        return map;
    }

    /**
     *
     * @param cityId
     * @return
     */
    private static Map<String,Object> getTodayWeather2(String cityId)
                        throws IOException ,NullPointerException{
        URL url=new URL("http://www.weather.com.cn/data/cityinfo/"+cityId+".html");
        URLConnection connectionData=url.openConnection();
        connectionData.setConnectTimeout(1000);
        Map<String,Object> map =new HashMap<String,Object>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connectionData.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null)
                sb.append(line);
            String datas = sb.toString();
            System.out.println("输出2的结果：" + datas);
            JSONObject jsonData = JSONObject.fromObject(datas);
            JSONObject info = jsonData.getJSONObject("weatherinfo");
            map.put("city", info.getString("city").toString());// 城市
            map.put("temp1", info.getString("temp1").toString());// 最高温度
            map.put("temp2", info.getString("temp2").toString());// 最低温度
            map.put("weather", info.getString("weather").toString());//天气
            map.put("ptime", info.getString("ptime").toString());// 发布时间

        }catch (SocketTimeoutException e){
            System.out.println("连接超时");
        }catch (FileNotFoundException e){
            System.out.println("加载文件出错");
        }
        return map;
    }

    private static String getWeek(int iw){
        String weekStr="";
        switch (iw){
            case 1:
                weekStr = "星期天";
                break;
            case 2:
                weekStr = "星期一";
                break;
            case 3:
                weekStr = "星期二";
                break;
            case 4:
                weekStr = "星期三";
                break;
            case 5:
                weekStr = "星期四";
                break;
            case 6:
                weekStr = "星期五";
                break;
            case 7:
                weekStr = "星期六";
                break;
            default:
                break;
        }
        return weekStr;
    }


public static void main(String[] args){
        try{
            //测试获取实时天气1(包含风况，湿度)
            Map<String, Object> map = getTodayWeather1("101030100");
            System.out.println(map.get("city") + "\t" + map.get("temp")
                    + "\t" + map.get("WD") + "\t" + map.get("WS")
                    + "\t" + map.get("SD") + "\t" + map.get("time"));

            //测试获取实时天气2(包含天气，温度范围)
            Map<String, Object> map2 = getTodayWeather2("101010100");
            System.out.println(map2.get("city") + "\t" + map2.get("temp1")
                    + "\t" + map2.get("temp2") + "\t" + map2.get("weather")
                    + "\t" + map2.get("ptime"));

            //测试获取一周天气  这个URL有点问题，返回不了数据，先注释掉
			/*List<Map<String, Object>> listData = getWeekWeatherMap("101010100");
			for (int j = 0; j < listData.size(); j++) {
				Map<String, Object> wMap = listData.get(j);
				System.out.println(wMap.get("city") + "\t" + wMap.get("date_y")
						+ "\t" + wMap.get("week") + "\t" + wMap.get("weather")
						+ "\t" + wMap.get("temp") + "\t" + wMap.get("wind")
						+ "\t" + wMap.get("fl"));
			}*/

        }catch (Exception e){
            e.printStackTrace();
        }
}

















}

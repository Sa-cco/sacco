package com.example.demo;

import com.example.demo.weatherdemo.ReturnWeather;
import com.example.demo.weatherdemo.Weather;
import com.example.demo.weatherdemo.todayweather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Vector;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    ReturnWeather returnWeather;

    @Test
    public void contextLoads() {
        todayweather todayweather= returnWeather.gettodayweather("天津");
        System.out.println(todayweather);
        Vector<Weather> weather=returnWeather.getweatherList("天津");
        System.out.println(weather);
    }

}

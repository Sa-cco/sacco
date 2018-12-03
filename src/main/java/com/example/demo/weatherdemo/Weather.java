package com.example.demo.weatherdemo;

import java.util.Objects;

public class Weather {

    String date;
    String sunrise;
    String high;
    String low;
    String sunset;
    String api;
    String fx;
    String fl;
    String type;
    String notice;

    public Weather() {
    }

    public Weather(String date, String sunrise, String high, String low, String sunset, String api, String fx, String fl, String type, String notice) {
        this.date = date;
        this.sunrise = sunrise;
        this.high = high;
        this.low = low;
        this.sunset = sunset;
        this.api = api;
        this.fx = fx;
        this.fl = fl;
        this.type = type;
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(date, weather.date) &&
                Objects.equals(sunrise, weather.sunrise) &&
                Objects.equals(high, weather.high) &&
                Objects.equals(low, weather.low) &&
                Objects.equals(sunset, weather.sunset) &&
                Objects.equals(api, weather.api) &&
                Objects.equals(fx, weather.fx) &&
                Objects.equals(fl, weather.fl) &&
                Objects.equals(type, weather.type) &&
                Objects.equals(notice, weather.notice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, sunrise, high, low, sunset, api, fx, fl, type, notice);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", sunset='" + sunset + '\'' +
                ", api='" + api + '\'' +
                ", fx='" + fx + '\'' +
                ", fl='" + fl + '\'' +
                ", type='" + type + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }
}

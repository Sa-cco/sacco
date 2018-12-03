package com.example.demo.weatherdemo;

import java.util.Objects;

public class todayweather {

    private String shidu;
    private String pm25;
    private String pm10;
    private String quality;
    private String wendu;
    private String ganmao;

    public todayweather() {
    }

    public todayweather(String shidu, String pm25, String pm10, String quality, String wendu, String ganmao) {
        this.shidu = shidu;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.quality = quality;
        this.wendu = wendu;
        this.ganmao = ganmao;
    }

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        todayweather that = (todayweather) o;
        return Objects.equals(shidu, that.shidu) &&
                Objects.equals(pm25, that.pm25) &&
                Objects.equals(pm10, that.pm10) &&
                Objects.equals(quality, that.quality) &&
                Objects.equals(wendu, that.wendu) &&
                Objects.equals(ganmao, that.ganmao);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shidu, pm25, pm10, quality, wendu, ganmao);
    }

    @Override
    public String toString() {
        return "todayweather{" +
                "shidu='" + shidu + '\'' +
                ", pm25='" + pm25 + '\'' +
                ", pm10='" + pm10 + '\'' +
                ", quality='" + quality + '\'' +
                ", wendu='" + wendu + '\'' +
                ", ganmao='" + ganmao + '\'' +
                '}';
    }
}

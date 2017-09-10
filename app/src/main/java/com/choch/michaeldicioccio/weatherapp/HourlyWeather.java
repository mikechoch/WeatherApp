package com.choch.michaeldicioccio.weatherapp;

/**
 * Created by michaeldicioccio on 9/9/17.
 */

public class HourlyWeather {

    /* Attributes */
    private String date;
    private String condition;
    private int temperature;
    private int wind_mph;
    private int humidity;
    private int precipitation;
    private int icon;

    HourlyWeather() {

    }

    HourlyWeather(String date, String condition, int temperature, int wind_mph, int humidity, int precipitation) {
        this.date = date;
        this.condition = condition;
        this.temperature = temperature;
        this.wind_mph = wind_mph;
        this.humidity = humidity;
        this.precipitation = precipitation;
    }

    /* Getters */
    public String getDate() {
        return date;
    }

    public String getCondition() {
        return condition;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getWind() {
        return wind_mph;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public int getIcon() {
        return icon;
    }

    /* Setters */
    public void setDate(String date) {
        this.date = date;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setWind(int wind_mph) {
        this.wind_mph = wind_mph;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

}

package com.choch.michaeldicioccio.weatherapp;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by michaeldicioccio on 9/9/17.
 */

public class Weather {

    /* Attributes */
    private String date;
    private String condition;
    private int temperature;
    private int temperature_high;
    private int temperature_low;
    private int wind_mph;
    private int humidity;
    private int precipitation;
    private int icon;
    private ArrayList<HourlyWeather> hourlyWeatherArrayList;

    Weather() {

    }

    Weather(String date, String condition, int temperature, int temperature_high, int temperature_low, int wind_mph, int humidity, int precipitation, int icon) {
        this.date = date;
        this.condition = condition;
        this.temperature = temperature;
        this.temperature_high = temperature_high;
        this.temperature_low = temperature_low;
        this.wind_mph = wind_mph;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.icon = icon;
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

    public int getTemperatureHigh() {
        return temperature_high;
    }

    public int getTemperatureLow() {
        return temperature_low;
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

    public ArrayList<HourlyWeather> getHourlyWeatherArrayList() {
        return hourlyWeatherArrayList;
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

    public void setTemperatureHigh(int temperature_high) {
        this.temperature_high = temperature_high;
    }

    public void setTemperatureLow(int temperature_low) {
        this.temperature_low = temperature_low;
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

    public void setHourlyWeatherArrayList(ArrayList<HourlyWeather> hourlyWeatherArrayList) {
        this.hourlyWeatherArrayList = hourlyWeatherArrayList;
    }

}

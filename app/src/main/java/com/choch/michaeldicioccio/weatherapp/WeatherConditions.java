package com.choch.michaeldicioccio.weatherapp;

/**
 * Created by michaeldicioccio on 9/9/17.
 */

public enum WeatherConditions {

    SUNNY("Sunny"),
    PARTLY_CLOUDY("Partly Cloudy"),
    CLOUDY("Cloudy"),
    RAINY("Rainy");

    private final String condition;

    WeatherConditions(String condition) {
        this.condition = condition;
    }

    public String getStringCondition() {
        return condition;
    }

}

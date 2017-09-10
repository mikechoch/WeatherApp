package com.choch.michaeldicioccio.weatherapp;

/**
 * Created by michaeldicioccio on 9/9/17.
 */

public enum WeatherConditions {

    SUNNY("Sunny", R.drawable.weather_sunny),
    PARTLY_CLOUDY("Partly Cloudy", R.drawable.weather_partlycloudy),
    CLOUDY("Cloudy", R.drawable.weather_cloudy),
    OVERCAST("Overcast", R.drawable.weather_cloudy),
    RAINY("Rain", R.drawable.weather_rainy),
    CLEAR("Clear", R.drawable.weather_night);

    private final String condition;
    private final int icon;

    WeatherConditions(String condition, int icon) {
        this.condition = condition;
        this.icon = icon;
    }

    public String getStringCondition() {
        return condition;
    }

    public int getIcon() {
        return icon;
    }

}

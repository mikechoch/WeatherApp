package com.choch.michaeldicioccio.weatherapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by michaeldicioccio on 9/9/17.
 */

public class NowFragment extends Fragment {

    private Weather currentWeather;

    public NowFragment() {
        // Required empty public constructor
        currentWeather = new Weather();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.now_fragment_layout, container, false);

        TextView conditionTextView = (TextView) view.findViewById(R.id.condition_text_view);
        TextView timeTextView = (TextView) view.findViewById(R.id.time_text_view);
        TextView temperatureTextView = (TextView) view.findViewById(R.id.temperature_text_view);
        TextView temperatureHighTextView = (TextView) view.findViewById(R.id.temperature_high_text_view);
        TextView temperatureLowTextView = (TextView) view.findViewById(R.id.temperature_low_text_view);
        TextView humidityTextView = (TextView) view.findViewById(R.id.humidity_text_view);
        TextView precipitationTextView = (TextView) view.findViewById(R.id.precipitation_text_view);
        TextView windTextView = (TextView) view.findViewById(R.id.wind_text_view);
        ImageView iconImageView = (ImageView) view.findViewById(R.id.weather_icon);

        conditionTextView.setText(currentWeather.getCondition());

        DateFormat df = new SimpleDateFormat("HH:mm");
        Date dateobj = new Date();
        timeTextView.setText("(Last Updated: " + df.format(dateobj) + ")");

        temperatureTextView.setText((String.valueOf(currentWeather.getTemperature()) + "°F"));
        temperatureHighTextView.setText("HI: " + String.valueOf(currentWeather.getTemperatureHigh()) + "°F");
        temperatureLowTextView.setText("LO:" + String.valueOf(currentWeather.getTemperatureLow()) + "°F");
        humidityTextView.setText(("Humidity: " + String.valueOf(currentWeather.getHumidity()) + "%"));
        precipitationTextView.setText(("Precipitation: " + String.valueOf(currentWeather.getPrecipitation()) + "%"));
        windTextView.setText(("Wind: " +(String.valueOf(currentWeather.getWind()) + " mph")));
        iconImageView.setImageResource(currentWeather.getIcon());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_calls_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void setCurrentWeather(Weather currentWeather) {
        this.currentWeather = currentWeather;
    }

}

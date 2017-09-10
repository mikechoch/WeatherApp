package com.choch.michaeldicioccio.weatherapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by michaeldicioccio on 9/9/17.
 */

public class HourRecyclerViewAdapter extends RecyclerView.Adapter<HourRecyclerViewAdapter.ViewHolder> {

    private List<HourlyWeather> items;
    private int itemLayout;

    public HourRecyclerViewAdapter(int itemLayout, List<HourlyWeather> items) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        HourlyWeather weather = items.get(position);
        holder.timeTextView.setText(weather.getDate());
        holder.conditionTextView.setText(weather.getCondition());
        holder.temperatureTextView.setText(String.valueOf(weather.getTemperature() + "°F"));
        holder.humidityTextView.setText(("Humidity: " + String.valueOf(weather.getHumidity()) + "%"));
        holder.precipitationTextView.setText(("Precipitation: " + String.valueOf(weather.getPrecipitation()) + "%"));
        holder.windTextView.setText(("Wind: " +(String.valueOf(weather.getWind()) + " mph")));
        holder.iconImageView.setImageResource(weather.getIcon());
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView timeTextView;
        public TextView conditionTextView;
        public TextView temperatureTextView;
        public TextView humidityTextView;
        public TextView precipitationTextView;
        public TextView windTextView;
        public ImageView iconImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            timeTextView = (TextView) itemView.findViewById(R.id.hour_text_view);
            conditionTextView = (TextView) itemView.findViewById(R.id.condition_text_view);
            temperatureTextView = (TextView) itemView.findViewById(R.id.temperature_text_view);
            humidityTextView = (TextView) itemView.findViewById(R.id.humidity_text_view);
            precipitationTextView = (TextView) itemView.findViewById(R.id.precipitation_text_view);
            windTextView = (TextView) itemView.findViewById(R.id.wind_text_view);
            iconImageView = (ImageView) itemView.findViewById(R.id.weather_icon);

        }
    }
}

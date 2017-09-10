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

public class DayRecyclerViewAdapter extends RecyclerView.Adapter<DayRecyclerViewAdapter.ViewHolder> {

    private List<Weather> items;
    private int itemLayout;

    public DayRecyclerViewAdapter(int itemLayout, List<Weather> items) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Weather weather = items.get(position);
        holder.dateTextView.setText(weather.getDate());
        holder.conditionTextView.setText(weather.getCondition());
        holder.temperatureTextView.setText(weather.getTemperatureHigh() + "/" + weather.getTemperatureLow());
        holder.iconImageView.setImageResource(weather.getIcon());
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dateTextView;
        public TextView conditionTextView;
        public TextView temperatureTextView;
        public ImageView iconImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.date_text_view);
            conditionTextView = (TextView) itemView.findViewById(R.id.condition_text_view);
            temperatureTextView = (TextView) itemView.findViewById(R.id.temperature_high_low_text_view);
            iconImageView = (ImageView) itemView.findViewById(R.id.weather_icon);

        }
    }
}

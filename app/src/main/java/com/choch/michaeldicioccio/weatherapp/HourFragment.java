package com.choch.michaeldicioccio.weatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaeldicioccio on 9/9/17.
 */

public class HourFragment extends Fragment {

    private RecyclerView hourRecyclerView;

    private ArrayList<Weather> hourWeatherDataArrayList;

    public HourFragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.hour_fragment_layout, container, false);

        hourWeatherDataArrayList = new ArrayList<>();

        hourRecyclerView = (RecyclerView) view.findViewById(R.id.hour_recycler_view);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_calls_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void setHourWeatherDataArrayList(List<Weather> weatherDataArrayList) {
        hourWeatherDataArrayList = new ArrayList<>(weatherDataArrayList);
        RecyclerViewAdapter hourRecyclerViewAdapter = new RecyclerViewAdapter(R.layout.recycler_view_item, hourWeatherDataArrayList);
        hourRecyclerView.setAdapter(hourRecyclerViewAdapter);
        hourRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        hourRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}

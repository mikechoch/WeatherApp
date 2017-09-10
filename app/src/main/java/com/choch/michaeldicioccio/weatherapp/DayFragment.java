package com.choch.michaeldicioccio.weatherapp;

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

public class DayFragment extends Fragment {

    private RecyclerView dayRecyclerView;

    private ArrayList<Weather> dayWeatherDataArrayList;

    public DayFragment() {
        // Required empty public constructor
        dayWeatherDataArrayList = new ArrayList<>();
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
        View view = inflater.inflate(R.layout.day_fragment_layout, container, false);

        dayRecyclerView = (RecyclerView) view.findViewById(R.id.day_recycler_view);
        DayRecyclerViewAdapter dayRecyclerViewAdapter = new DayRecyclerViewAdapter(R.layout.day_recycler_view_item, dayWeatherDataArrayList);
        dayRecyclerView.setAdapter(dayRecyclerViewAdapter);
        dayRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dayRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_calls_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void setDayWeatherDataArrayList(List<Weather> weatherDataArrayList) {
        dayWeatherDataArrayList = new ArrayList<>(weatherDataArrayList);
    }
}

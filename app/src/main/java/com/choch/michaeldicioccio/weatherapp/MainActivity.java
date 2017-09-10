package com.choch.michaeldicioccio.weatherapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private MultiSwipeRefreshLayout multiSwipeRefreshLayout;

    private NowFragment nowFragment;
    private HourFragment hourFragment;
    private DayFragment dayFragment;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupFab();
        setupViewPager();
        setupMultiSwipeRefreshLayout();

        new WeatherDataTask().execute();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 100) && (resultCode == FeelingsActivity.RESULT_OK)) {
            Toast.makeText(this, String.valueOf(data.getIntExtra("feeling", -1)), Toast.LENGTH_SHORT).show();
        }
    }

    private void setupFab() {
        //Initializing weatherFeelingFloatingActionButton
        FloatingActionButton weatherFeelingFloatingActionButton = (FloatingActionButton) findViewById(R.id.weather_feeling_fab);

        //Create click listener for weatherFeelingFloatingActionButton
        weatherFeelingFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, FeelingsActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    private void setupViewPager() {
        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);

        //Initializing viewPagerAdapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Create all fragments for viewPager
        nowFragment = new NowFragment();
        hourFragment = new HourFragment();
        dayFragment = new DayFragment();

        //Add all fragments to viewPager
        viewPagerAdapter.addFragment(nowFragment, "NOW");
        viewPagerAdapter.addFragment(hourFragment, "HOUR");
        viewPagerAdapter.addFragment(dayFragment, "DAY");

        //Set viewPagerAdapter as the adapter for viewPager
        viewPager.setAdapter(viewPagerAdapter);

        //Create page change listener for viewPager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //When the page is changed set the current viewPager page to that position
                viewPager.setCurrentItem(position, false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //Initializing the tabLayout
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupMultiSwipeRefreshLayout() {
        //Initializing the multiSwipeRefreshLayout
        multiSwipeRefreshLayout = (MultiSwipeRefreshLayout) findViewById(R.id.swipe_refresh_multi_view);
        multiSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        multiSwipeRefreshLayout.setSwipeableChildren(R.id.viewpager);

        //Create refresh listener for multiSwipeRefreshLayout
        multiSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new WeatherDataTask().execute();
            }
        });
    }

    private class WeatherDataTask extends AsyncTask<Void, Void, List<Weather>> {

        @Override
        protected ArrayList<Weather> doInBackground(Void... params) {
            ArrayList<Weather> weatherArrayList = new ArrayList<>();
            WeatherDataJson weatherDataJson = new WeatherDataJson();
            try {
                weatherArrayList = weatherDataJson.parseJson(weatherDataJson.getJsonFromUrl("https://api.apixu.com/v1/forecast.json?key=e763d5cf81a040e89b925722171605&q=Philadelphia&days=10"));
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return weatherArrayList;
        }

        @Override
        protected void onPostExecute(List<Weather> result) {
            super.onPostExecute(result);
            nowFragment.setCurrentWeather(result.get(0));
            hourFragment.setHourWeatherDataArrayList(result.get(0).getHourlyWeatherArrayList());
            dayFragment.setDayWeatherDataArrayList(result);

            viewPagerAdapter.notifyDataSetChanged();

            if (multiSwipeRefreshLayout.isRefreshing()) {
                multiSwipeRefreshLayout.setRefreshing(false);
            }
        }

    }
}

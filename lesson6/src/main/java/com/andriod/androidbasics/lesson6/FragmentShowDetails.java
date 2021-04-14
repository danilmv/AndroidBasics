package com.andriod.androidbasics.lesson6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andriod.androidbasics.lesson6.data.City;
import com.andriod.androidbasics.lesson6.data.Weather;

public class FragmentShowDetails extends Fragment {
    private City city;
    private boolean isLandscape;

    public FragmentShowDetails() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public FragmentShowDetails(City city) {
        this.city = city;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view) {
        if (city != null) {
            TextView cityName = view.findViewById(R.id.city_name);
            cityName.setText(city.getName());

            Weather weather = city.getCurrentWeather();
            if (weather != null) {
                TextView temperature = view.findViewById(R.id.temperature);
                temperature.setText(weather.getFormattedTemperature(true));

                TextView wind = view.findViewById(R.id.wind);
                wind.setText(weather.getFormattedWind(true));

                TextView humidity = view.findViewById(R.id.humidity);
                humidity.setText(weather.getFormattedHumidity(true));

                TextView precipitation = view.findViewById(R.id.precipitation);
                precipitation.setText(weather.getFormattedPrecipitation(true));


                RecyclerView forecastList = view.findViewById(R.id.recyclerView);
                LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                forecastList.setLayoutManager(layoutManager);

                DetailsForecastListAdapter adapter = new DetailsForecastListAdapter();
                adapter.setCity(city);
                forecastList.setAdapter(adapter);
            }
        }
    }
}

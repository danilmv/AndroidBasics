package com.andriod.androidbasics.lesson6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.andriod.androidbasics.lesson6.data.City;
import com.andriod.androidbasics.lesson6.data.Weather;

public class ShowDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        City city = (City) getIntent().getExtras().getSerializable(City.EXTRA);

        if (city != null) {
            TextView cityName = findViewById(R.id.city_name);
            cityName.setText(city.getName());

            Weather weather = city.getCurrentWeather();
            if (weather != null) {
                TextView temperature = findViewById(R.id.temperature);
                temperature.setText(weather.getFormattedTemperature(true));

                TextView wind = findViewById(R.id.wind);
                wind.setText(weather.getFormattedWind(true));

                TextView humidity = findViewById(R.id.humidity);
                humidity.setText(weather.getFormattedHumidity(true));

                TextView precipitation = findViewById(R.id.precipitation);
                precipitation.setText(weather.getFormattedPrecipitation(true));


                RecyclerView forecastList = findViewById(R.id.recyclerView);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                forecastList.setLayoutManager(layoutManager);

                DetailsForecastListAdapter adapter = new DetailsForecastListAdapter();
                adapter.setCity(city);
                forecastList.setAdapter(adapter);
            }
        }
    }
}
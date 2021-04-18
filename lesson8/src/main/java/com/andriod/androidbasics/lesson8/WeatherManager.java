package com.andriod.androidbasics.lesson8;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import com.andriod.androidbasics.lesson8.interfaces.DataIsReady;
import com.andriod.androidbasics.lesson8.model.OpenWeatherData;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class WeatherManager {
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s";

    public void getWeather(String city, DataIsReady listener) {
        try {
            final URL url = new URL(String.format(WEATHER_URL, city, BuildConfig.WEATHER_API_KEY));

            new Thread(() -> {
                OpenWeatherData data = null;
                HttpsURLConnection urlConnection = null;

                try {
                    urlConnection = (HttpsURLConnection) (url.openConnection());
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setReadTimeout(10000);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String result = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                        result = reader.lines().collect(Collectors.joining("\n"));
                    }

                    Gson gson = new Gson();
                    if (result != null)
                        data = gson.fromJson(result, OpenWeatherData.class);

                } catch (IOException e) {
                    e.printStackTrace();
//                    Looper.prepare();
                    listener.showError(String.format("Error while getting weather: %s", e.getMessage()));
                } finally {
                    if (urlConnection != null)
                        urlConnection.disconnect();

                    if (data != null)
                        listener.showData(data);
                }
            }).start();
        } catch (MalformedURLException e) {
            e.printStackTrace();
//            Looper.prepare();
            listener.showError(String.format("Wrong url: %s", e.getMessage()));
        }
    }
}

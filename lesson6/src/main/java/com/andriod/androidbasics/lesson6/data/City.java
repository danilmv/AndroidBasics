package com.andriod.androidbasics.lesson6.data;

import java.io.Serializable;

public class City implements Serializable {
    public static final String EXTRA = "CITY";


    private String name;
    private WeatherStory weather = WeatherStory.getSomeStory();

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Weather getCurrentWeather() {
        return weather.getCurrent();
    }

    public Weather getWeatherForecast(int inDays) {
        return weather.getNext(inDays);
    }

    public String getDay(int inDays) {
        return weather.getNextDate(inDays);
    }

    public int getNumForecasts() {
        return weather.getNumForecasts();
    }
}

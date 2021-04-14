package com.andriod.androidbasics.lesson6.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class WeatherStory implements Serializable {
    private Map<String, Map<String, Weather>> story = new HashMap<>();
    private int numForecasts;

    public void add(String date, String time, Weather weather) {
        if (!story.containsKey(date))
            story.put(date, new HashMap<>());

        Map<String, Weather> day = story.get(date);
        day.put(time, weather);
    }

    private Weather getWeatherIn(String date) {
        Map<String, Weather> today = story.get(date);
        if (today == null) return null;

        //пока вернем первое попавшее значение
        for (Map.Entry<String, Weather> stringWeatherEntry : today.entrySet()) {
            return stringWeatherEntry.getValue();
        }
        return null;
    }

    public Weather getCurrent() {
        return getWeatherIn(Utils.getCurrentDate());
    }

    public Weather getNext(int offset) {
        return getWeatherIn(Utils.getFollowingDay(offset));
    }

    public String getNextDate(int offset) {
        return Utils.getFollowingDay(offset);
    }

    public static WeatherStory getSomeStory() {
        WeatherStory generated = new WeatherStory();
        generated.add(Utils.getCurrentDate(), "", Weather.getRandomWeather());
        generated.add(Utils.getFollowingDay(1), "", Weather.getRandomWeather());
        generated.add(Utils.getFollowingDay(2), "", Weather.getRandomWeather());
        generated.add(Utils.getFollowingDay(3), "", Weather.getRandomWeather());
        return generated;
    }

    public int getNumForecasts() {
//     return numForecasts;
        return 3;
    }
}

package com.andriod.androidbasics.lesson8.interfaces;

import com.andriod.androidbasics.lesson8.model.OpenWeatherData;

public interface DataIsReady {
    void showData(OpenWeatherData data);
    void showError(String message);
}

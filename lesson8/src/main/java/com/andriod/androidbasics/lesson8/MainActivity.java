package com.andriod.androidbasics.lesson8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.andriod.androidbasics.lesson8.interfaces.DataIsReady;
import com.andriod.androidbasics.lesson8.model.OpenWeatherData;

public class MainActivity extends AppCompatActivity implements DataIsReady {
    private Handler handler;
    private static final WeatherManager weatherManager = new WeatherManager();

    private TextView temperature;
    private TextView humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();

        TextView textView = findViewById(R.id.inputCityName);
        temperature = findViewById(R.id.temperature);
        humidity = findViewById(R.id.humidity);

        Button buttonGet = findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(v -> weatherManager.getWeather(textView.getText().toString(), this));
    }

    @Override
    public void showData(OpenWeatherData data) {
        handler.post(() -> {
            temperature.setText(String.valueOf(data.getTemperature()));
            humidity.setText(String.valueOf(data.getHumidity()));
        });
    }

    @Override
    public void showError(String message) {
        handler.post(() -> {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });
    }
}
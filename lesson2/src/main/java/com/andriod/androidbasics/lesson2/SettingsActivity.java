package com.andriod.androidbasics.lesson2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        ImageButton buttonBack = findViewById(R.id.imageButtonBack);
        buttonBack.setOnClickListener(v -> {

        });
    }
}

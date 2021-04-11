package com.andriod.androidbasics.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_hello);
        button.setOnClickListener(v -> {
            TextView textView = findViewById(R.id.text_hello);
            textView.setText(textView.getText() + " " + "hello");
        });

        ImageButton button2 = findViewById(R.id.imageButton);
        button2.setOnClickListener(v -> {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
        });
    }
}
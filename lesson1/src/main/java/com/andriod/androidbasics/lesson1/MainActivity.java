package com.andriod.androidbasics.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    static StringBuilder sb = new StringBuilder();
    TextView textEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEvents = findViewById(R.id.events);

        sb.append(Calendar.getInstance().getTime() + ": onCreate\n");
        textEvents.setText(sb);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sb.append(Calendar.getInstance().getTime() + ": onStart\n");
        textEvents.setText(sb);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sb.append(Calendar.getInstance().getTime() + ": onPause\n");
        textEvents.setText(sb);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sb.append(Calendar.getInstance().getTime() + ": onResume\n");
        textEvents.setText(sb);
    }
}
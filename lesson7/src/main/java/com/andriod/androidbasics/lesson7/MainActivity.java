package com.andriod.androidbasics.lesson7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText text = findViewById(R.id.text_input_text);
        text.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) return;
            TextView t = (TextView) v;

            if (!t.getText().toString().equals("текст")) {
                t.setError("Введите 'текст'");
            } else
                t.setError(null);
        });

        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        // Обработка нажатия на плавающую кнопку
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Здесь вылетит Snackbar
                Snackbar.make(view, "Вы нажали на плавающую кнопку", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
}
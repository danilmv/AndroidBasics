package com.andriod.androidbasics.lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements Constants {
    private boolean resultConfirmed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        ImageButton buttonBack = findViewById(R.id.imageButtonBack);
        buttonBack.setOnClickListener(v -> {
            resultConfirmed = true;

            Intent intentResult = new Intent();
            EditText editText = findViewById(R.id.editText);
            String message = editText.getText().toString();
            intentResult.putExtra(TEXT_VALUE, message);
            setResult(RESULT_OK, intentResult);

            this.finish();
        });

        Bundle data = getIntent().getExtras();
        if (data != null) {
            EditText editText = findViewById(R.id.editText);
            editText.setText(data.getString(TEXT_VALUE));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if (resultConfirmed) {
//            Intent intentResult = new Intent();
//            EditText editText = findViewById(R.id.editText);
//            intentResult.putExtra(TEXT_VALUE, editText.getText());
//            setResult(RESULT_OK, intentResult);
//        } else
//            setResult(RESULT_CANCELED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Settings: onDestroy: " + isFinishing(), Toast.LENGTH_SHORT).show();
    }
}

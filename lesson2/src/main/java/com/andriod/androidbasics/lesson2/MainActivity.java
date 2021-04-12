package com.andriod.androidbasics.lesson2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Constants {
    private final static int MYCODE = 10;

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

        Button buttonSendData = findViewById(R.id.button2);
        buttonSendData.setOnClickListener(v -> {
            Intent settingsIntentWithData = new Intent(this, SettingsActivity.class);
            EditText editText = findViewById(R.id.editText);
            String text = editText.getText().toString();
            settingsIntentWithData.putExtra(TEXT_VALUE, text);
            startActivityForResult(settingsIntentWithData, MYCODE);
        });

        Button buttonWeb = findViewById(R.id.buttonCallBrowser);
        buttonWeb.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.editTextURL);
            Uri uri = Uri.parse(editText.getText().toString());
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        });

        //send data to Activity @lesson3
        Button buttonFindActivity = findViewById(R.id.buttonFindActivity);
        buttonFindActivity.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.editText_myUrl);
            Uri uri = Uri.parse(editText.getText().toString());

            Intent runEchoIntent = new Intent(Intent.ACTION_VIEW, uri);

            //checking if desired Activity exist
            ActivityInfo activityInfo = runEchoIntent.resolveActivityInfo(getPackageManager(), runEchoIntent.getFlags());
            if (activityInfo != null) startActivity(runEchoIntent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != MYCODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == RESULT_OK) {
            EditText editText = findViewById(R.id.editText);
            String message = data.getStringExtra(TEXT_VALUE);
            editText.setText(message);
        }
    }
}
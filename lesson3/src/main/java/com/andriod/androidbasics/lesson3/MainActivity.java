package com.andriod.androidbasics.lesson3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "OnOptionsItemSelected: " + item.toString(), Toast.LENGTH_SHORT).show();
        Log.d("Menu", "OnOptionsItemSelected: " + item.toString());

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(MyPresenter.getInstance().getCounter()));

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            textView.setText(String.valueOf(MyPresenter.getInstance().increase()));
        });

        ConstraintLayout container = findViewById(R.id.container);
        container.setOnTouchListener((v, event) -> {
            Toast.makeText(v.getContext(), "OnTouch", Toast.LENGTH_SHORT).show();
            Log.d("Container", "OnTouch");
            return false;
        });

        container.setOnLongClickListener(v -> {
            Toast.makeText(v.getContext(), "OnLongClick", Toast.LENGTH_SHORT).show();
            Log.d("Container", "OnLongClick");
            return false;
        });

        container.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "OnClick", Toast.LENGTH_SHORT).show();
            Log.d("Container", "OnClick");
        });

        //receiving data from Activity @lesson2
        Uri uri = getIntent().getData();
        if (uri != null) {
            String receivedText = uri.getLastPathSegment();
            TextView textViewReceived = findViewById(R.id.textViewReceivedData);
            textViewReceived.setText(receivedText);
        }

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Toast.makeText(this, "onPostResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy: isFinishing?" + isFinishing());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Toast.makeText(this, "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Toast.makeText(this, "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestoreInstanceState");
    }


}
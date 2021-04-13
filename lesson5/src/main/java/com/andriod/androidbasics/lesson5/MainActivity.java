package com.andriod.androidbasics.lesson5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private boolean isLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (isLandscape) {
            FragmentList fragmentList = new FragmentList();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list_fragment, fragmentList)
                    .replace(R.id.drawable_fragment, new FragmentDrawable(fragmentList.getCurrentParcel()))
                    .commit();
        } else
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, new FragmentList())
                    .commit();
    }
}
package com.andriod.androidbasics.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private boolean isLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!Presenter.isInitiated())
            Presenter.init(getResources().getStringArray(R.array.cities));

        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (isLandscape) {
            FragmentListOfCities fragmentList = new FragmentListOfCities();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list_fragment, fragmentList)
                    .replace(R.id.details_fragment, new FragmentShowDetails(fragmentList.getCurrentCity()))
                    .commit();
        } else
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list_fragment, new FragmentListOfCities())
                    .commit();

    }
}
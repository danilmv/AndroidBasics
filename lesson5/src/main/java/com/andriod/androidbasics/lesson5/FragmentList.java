package com.andriod.androidbasics.lesson5;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentList extends Fragment {
    private final String PARCEL = "Parcel";

    private Parcel currentParcel;
    private boolean isLandscape;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layout = (LinearLayout) view;
        String[] names = getResources().getStringArray(R.array.names);

        for (int i = 0; i < names.length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(names[i]);

            layout.addView(textView);
            int finalI = i;
            textView.setOnClickListener(v -> {
                currentParcel = new Parcel(finalI, getResources().getStringArray(R.array.names)[finalI]);
                showDrawable(currentParcel);
            });
        }
    }

    private void showDrawable(Parcel currentParcel) {
        //FragmentManager works at Activity-level, so id's are from there
        if (isLandscape) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.drawable_fragment, new FragmentDrawable(currentParcel))
                    .addToBackStack(null)
                    .commit();
        } else {
            getFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, new FragmentDrawable(currentParcel))
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(PARCEL, currentParcel);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            currentParcel = (Parcel) savedInstanceState.getSerializable(PARCEL);
        } else
            currentParcel = new Parcel(0, getResources().getStringArray(R.array.names)[0]);
    }

    public Parcel getCurrentParcel() {
        return currentParcel;
    }
}

package com.andriod.androidbasics.lesson5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDrawable extends Fragment {
    private Parcel parcel;

    public FragmentDrawable() {
    }

    public FragmentDrawable(Parcel parcel) {
        this.parcel = parcel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_drawable, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view) {
        if (parcel != null) {
            TextView textView = view.findViewById(R.id.text_view);
            textView.setText(parcel.getName());

            ImageView imageView = view.findViewById(R.id.image_view);
            imageView.setImageResource(getResources().obtainTypedArray(R.array.drawables).getResourceId(parcel.getIndex(), -1));
        }
    }
}

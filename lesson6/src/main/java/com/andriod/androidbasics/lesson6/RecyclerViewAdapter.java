package com.andriod.androidbasics.lesson6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.andriod.androidbasics.lesson6.data.City;

import java.util.Locale;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        if (listener != null)
            viewHolder.setOnClickListener(listener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(Presenter.getDataManager().getCity(position));
    }

    @Override
    public int getItemCount() {
        return Presenter.getDataManager().getSize();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cityName;
        TextView cityTemperature;
        CardView container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.container);
            cityName = itemView.findViewById(R.id.city_name);
            cityTemperature = itemView.findViewById(R.id.city_temperature);
        }

        public void setData(City city) {
            cityName.setText(city.getName());
            cityTemperature.setText(city.getCurrentWeather().getFormattedTemperature(false));
        }

        public void setOnClickListener(ItemClickListener listener) {
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(Presenter.getDataManager().getCity(getAdapterPosition()));
                }
            });
        }
    }

    public interface ItemClickListener {
        void onItemClick(City city);
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }
}


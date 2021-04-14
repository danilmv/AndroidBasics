package com.andriod.androidbasics.lesson6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andriod.androidbasics.lesson6.data.City;
import com.andriod.androidbasics.lesson6.data.Weather;

public class DetailsForecastListAdapter extends RecyclerView.Adapter<DetailsForecastListAdapter.ViewHolder> {

    private City city;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather_forecast, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(city, position);
    }

    @Override
    public int getItemCount() {
        return city.getNumForecasts();
    }

    public void setCity(City city) {
        this.city = city;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView date;
        private TextView temperature;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            temperature = itemView.findViewById(R.id.temperature);
        }

        public void setData(City city, int index) {
            if (city != null) {
                date.setText(city.getDay(index + 1));

                Weather forecast = city.getWeatherForecast(index + 1);
                temperature.setText(forecast.getFormattedTemperature(false));
            }
        }
    }
}

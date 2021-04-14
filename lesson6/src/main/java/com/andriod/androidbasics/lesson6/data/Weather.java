package com.andriod.androidbasics.lesson6.data;

import java.io.Serializable;
import java.util.Locale;
import java.util.Random;

public class Weather implements Serializable {
    private static final String[] DIRECTIONS = {"Ю", "ЮВ", "В", "СВ", "С", "СЗ", "З", "ЮЗ"};
    private static final String[] PRECIPITATION = {"ясно", "снег", "дождь"};
    private static final String CELSIUS = "\u2103";

    private float temperature;
    private String windDirection;
    private float windSpeed;
    private int humidity;
    private boolean isPrecipitation;

    public Weather(float temperature, String windDirection, float windSpeed, int humidity, boolean isPrecipitation) {
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.isPrecipitation = isPrecipitation;
    }

    public static Weather getRandomWeather() {

        Random random = new Random();

        return new Weather(random.nextFloat() * 60 - 30,
                DIRECTIONS[random.nextInt(DIRECTIONS.length)],
                random.nextFloat() * 30,
                random.nextInt(101),
                random.nextBoolean());
    }

    public float getTemperature() {
        return temperature;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public boolean isPrecipitation() {
        return isPrecipitation;
    }

    public String getFormattedTemperature(boolean withInfo) {
        if (withInfo)
            return String.format(Locale.getDefault(), "Температура: %.1f%s", getTemperature(), CELSIUS);
        else
            return String.format(Locale.getDefault(), "%.1f%s", getTemperature(), CELSIUS);
    }

    public String getFormattedWind(boolean withInfo) {
        if (withInfo)
            return String.format(Locale.getDefault(), "Ветер: %s, %.0f м/c", getWindDirection(), getWindSpeed());
        else
            return String.format(Locale.getDefault(), "%s, %.0f м/c", getWindDirection(), getWindSpeed());
    }

    public String getFormattedHumidity(boolean withInfo) {
        if (withInfo)
            return String.format(Locale.getDefault(), "Влажность: %d%%", getHumidity());
        else
            return String.format(Locale.getDefault(), "%d %%", getHumidity());
    }

    public String getFormattedPrecipitation(boolean withInfo) {
        String value;
        if (!isPrecipitation()) value = PRECIPITATION[0];
        else if (getTemperature() < 0) value = PRECIPITATION[1];
        else return value = PRECIPITATION[2];
        if (withInfo)
            return String.format(Locale.getDefault(), "Осадки: %s", value);
        else
            return String.format(Locale.getDefault(), "%s", value);

    }
}

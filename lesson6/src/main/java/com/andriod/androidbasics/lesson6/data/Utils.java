package com.andriod.androidbasics.lesson6.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utils {
    public static String getCurrentDate() {
        return new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    public static String getFollowingDay(int offset) {
        Date date = new Date();
        date.setTime(date.getTime() + 24 * 3600 * 1000 * offset);
        return new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(date);
    }
}

package com.andriod.androidbasics.lesson6;

import com.andriod.androidbasics.lesson6.data.DataManager;

public class Presenter {
    private static DataManager dataManager;

    public static void init(String[] names) {
        dataManager = new DataManager(names);
    }

    public static boolean isInitiated() {
        return dataManager != null;
    }

    public static DataManager getDataManager(){
        return dataManager;
    }
}

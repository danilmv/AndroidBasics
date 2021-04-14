package com.andriod.androidbasics.lesson6.data;

import java.util.ArrayList;
import java.util.List;


public class DataManager {
    private List<City> cities = new ArrayList<>();
    private String[] names;

    public DataManager(String[] names) {
        this.names = names;
        for (String name : this.names) cities.add(new City(name));
    }

    public int getSize(){
        return cities.size();
    }

    public City getCity(int index){
        return cities.get(index);
    }
}

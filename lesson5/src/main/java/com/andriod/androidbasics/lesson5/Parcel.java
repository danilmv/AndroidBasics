package com.andriod.androidbasics.lesson5;

import java.io.Serializable;

public class Parcel implements Serializable {
 private int index;
 private String name;

    public Parcel(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}

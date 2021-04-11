package com.andriod.androidbasics.lesson3;

public class MyPresenter {
    private static final MyPresenter instance = new MyPresenter();
    private int counter;

    public static MyPresenter getInstance() {
        return instance;
    }

    public int getCounter() {
        return counter;
    }

    public int increase(){
        return ++counter;
    }
}

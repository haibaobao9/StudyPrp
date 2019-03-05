package com.example.james.studypro.ObserverPattern;

import android.util.Log;

public class Man implements Observer{
    private String name;

    public Man(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        Log.d("xxy","man " + name + "received message :" + message);
    }
}

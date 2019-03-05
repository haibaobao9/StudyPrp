package com.example.james.studypro.ObserverPattern;

import android.util.Log;

public class Woman implements Observer {
    private String name;

    public Woman(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        Log.d("xxy","woman " + name + "received message :" + message);
    }
}

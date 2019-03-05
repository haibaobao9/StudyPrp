package com.example.james.studypro.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class PostMan implements Observable{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers){
            observer.update(message);
        }
    }
}

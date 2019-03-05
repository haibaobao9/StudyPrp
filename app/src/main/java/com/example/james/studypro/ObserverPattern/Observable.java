package com.example.james.studypro.ObserverPattern;

public interface Observable {
    public void add(Observer observer);
    public void remove(Observer observer);
    public void notify(String message);
}

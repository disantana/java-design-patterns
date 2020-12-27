package br.com.disantana.design.patterns.observer;

import java.util.List;

public class EmailTopic implements Subject {

    private List<Observer> observers;
    private String message;

    EmailTopic (List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public boolean register(Observer observer) {
        if (observers == null) throw new NullPointerException("Null object/observer");

        if (observers.contains(observer)) throw new RuntimeException("Oberver already exists");

        observers.add(observer);

        return true;
    }

    @Override
    public boolean unregister(Observer observer) {
        if (observer == null) throw new NullPointerException("Null observer passed");
        if (observers == null || !observers.contains(observer)) throw new NullPointerException("Observer not registered");
        observers.remove(observer);
        return true;
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update());
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String message) {
        System.out.println("Message posted to my topic : " + message);
        this.message = message;
        notifyObserver();
    }
}

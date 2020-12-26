package br.com.disantana.design.patterns.observer;

import java.util.List;

public class EmailTopic implements Subject {

    private List<Observer> observers;
    private String message;

    EmailTopic (List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void register(Observer observer) {
        if (observers == null) throw new NullPointerException("Null object/observer");
        if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
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

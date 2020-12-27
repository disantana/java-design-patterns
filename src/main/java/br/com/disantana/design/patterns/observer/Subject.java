package br.com.disantana.design.patterns.observer;

interface Subject {
    boolean register(Observer observer);
    boolean unregister(Observer observer);
    void notifyObserver();
    Object getUpdate(Observer observer);
}

package br.com.disantana.design.patterns.observer;

interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObserver();
    Object getUpdate(Observer observer);
}

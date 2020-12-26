package br.com.disantana.design.patterns.observer;

interface Observer {
    void update();
    void setSubject(Subject subject);
}

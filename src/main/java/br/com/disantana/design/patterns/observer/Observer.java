package br.com.disantana.design.patterns.observer;

interface Observer {
    String update();
    void setSubject(Subject subject);
}

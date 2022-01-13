package br.com.disantana.design.patterns.observer.payments;

public interface Account {
    String update();
    void setAccountTopicManager(AccountTopicManager subject);
}

package br.com.disantana.design.patterns.observer.payments;

public interface AccountTopicManager {
    boolean register(Account observer);
    boolean unregister(Account observer);
    boolean updateTopic(Account observer);
    Account first();
}

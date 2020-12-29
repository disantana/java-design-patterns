package br.com.disantana.design.patterns.observer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmailTopicSubscriberTest extends Assert {

    @Test
    public void update() {
        EmailTopic topic = new EmailTopic(getObservers());
        EmailTopicSubscriber subscriber = new EmailTopicSubscriber("Subscriber is observer");
        var message = "Message posted.";

        subscriber.setSubject(topic);
        topic.register(subscriber);
        topic.postMessage(message);

        assertEquals(subscriber.update(), message);
    }

    private List<Observer> getObservers() {
        List<Observer> observers = new ArrayList<>();
        return observers;
    }
}
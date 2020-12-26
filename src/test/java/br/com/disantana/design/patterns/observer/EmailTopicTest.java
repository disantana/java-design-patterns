package br.com.disantana.design.patterns.observer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class EmailTopicTest extends Assert {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    private EmailTopic emailTopic;

    @Before
    public void setUp() throws Exception {
        emailTopic = new EmailTopic(null);
    }

    @Test
    public void shouldReturnNPEWhenObserversNotInstantiated() {
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("Null object/observer");
        Observer observer = new EmailTopicSubscriber("Observer");
        emailTopic.register(observer);
    }

    @Test
    public void shouldRegisterNewObserverWithSuccess() {
        Observer observer = new EmailTopicSubscriber("observer");
        List<Observer> observers = new ArrayList<>();
        emailTopic = new EmailTopic(observers);
        assertTrue(emailTopic.register(observer));
    }


    @Test
    public void unregister() {
    }

    @Test
    public void notifyObserver() {
    }

    @Test
    public void getUpdate() {
    }

    @Test
    public void postMessage() {
    }
}
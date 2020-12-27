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
    private Observer observer;

    @Before
    public void setUp() throws Exception {
        emailTopic = new EmailTopic(null);
    }

    @Test
    public void shouldReturnNPEWhenObserversNotInstantiated() {
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("Null object/observer");
        Observer observer = createObserver("Observer");
        emailTopic.register(observer);
    }

    @Test
    public void shouldRegisterNewObserverWithSuccess() {
        observer = createObserver("observer");
        List<Observer> observers = getObservers();
        emailTopic = new EmailTopic(observers);
        assertTrue(emailTopic.register(observer));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenDuplicatedObserversIsAdded() {
        exceptionRule.expect(RuntimeException.class);
        Observer observer = createObserver("observer");
        Observer anotherObserver = observer;

        emailTopic.register(observer);
        emailTopic.register(anotherObserver);
    }

    @Test
    public void shouldThrowExceptionToNullObserver() {
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("Null observer passed");
        emailTopic.unregister(null);
    }

    @Test
    public void shouldThrowExceptionToUnregisteredObserver() {
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("Observer not registered");
        emailTopic.unregister(createObserver("unregistered"));
    }

    @Test
    public void shouldUnregisterWithSuccess() {
        List<Observer> observers = getObservers();
        EmailTopic topic = new EmailTopic(observers);
        Observer observerToUnregister = createObserver("Observer to unregister");
        topic.register(observerToUnregister);
        boolean unregistered = topic.unregister(observerToUnregister);
        assertTrue(unregistered);
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

    private Observer createObserver(String observer) {
        return new EmailTopicSubscriber(observer);
    }

    private List<Observer> getObservers() {
        List<Observer> observers = new ArrayList<>();
        return observers;
    }
}
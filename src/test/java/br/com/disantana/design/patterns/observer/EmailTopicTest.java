package br.com.disantana.design.patterns.observer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class EmailTopicTest extends Assert {


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Mock
    private EmailTopic emailTopic;
    private List<Observer> observers;

    @Before
    public void setUp() throws Exception {
        emailTopic = new EmailTopic(this.observers);
    }

    @Test
    public void shouldReturnNPEWhenObserversNotInstantiated() {
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("Null object/observer");
        Observer observer = new EmailTopicSubscriber("Observer");
        emailTopic.register(observer);
    }

    @Test
    public void shouldRegister() {
        Observer observer = new EmailTopicSubscriber("observer");
        EmailTopic mock = Mockito.mock(EmailTopic.class);
        mock.register(observer);
        Mockito.verify(mock, Mockito.times(1)).register(observer);

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
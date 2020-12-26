package br.com.disantana.design.patterns.observer;

public class EmailTopicSubscriber implements Observer {

    private String message;
    private Subject topic;

    EmailTopicSubscriber(String message) {
        this.message = message;
    }

    @Override
    public void update() {
        String message = (String) topic.getUpdate(this);
        if (message == null)
            System.out.println(this.message + " no new message on this topic!");
        else
            System.out.println(this.message +" Retrieving message: " + message);
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }
}

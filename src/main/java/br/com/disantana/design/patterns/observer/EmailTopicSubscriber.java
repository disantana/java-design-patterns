package br.com.disantana.design.patterns.observer;

public class EmailTopicSubscriber implements Observer {

    private String name;
    private Subject topic;

    EmailTopicSubscriber(String message) {
        this.name = message;
    }

    @Override
    public String update() {
        String message = (String) topic.getUpdate(this);
        if (message == null)
            System.out.println(this.name + " no new message on this topic!");
        else
            System.out.println(this.name +" Retrieving message: " + message);

        return message;
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }
}

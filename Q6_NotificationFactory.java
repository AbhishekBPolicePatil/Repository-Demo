package com.demo.demo;

interface Notification {

    void send(String message);

}

class EmailNotification implements Notification {

    @Override

    public void send(String message) {

        System.out.println("Sending Email: " + message);

    }

}

class SMSNotification implements Notification {

    @Override

    public void send(String message) {

        System.out.println("Sending SMS: " + message);

    }

}

class PushNotification implements Notification {

    @Override

    public void send(String message) {

        System.out.println("Sending Push: " + message);

    }

}

class NotificationFactory {

    public static Notification createNotification(String type) {

        switch (type.toLowerCase()) {

            case "email":

                return new EmailNotification();

            case "sms":

                return new SMSNotification();

            case "push":

                return new PushNotification();

            default:

                throw new IllegalArgumentException("Unknown notification type");

        }

    }

}

public class Q6_NotificationFactory {

    public static void main(String[] args) {

        Notification email = NotificationFactory.createNotification("email");

        email.send("Hello via Email");

        Notification sms = NotificationFactory.createNotification("sms");

        sms.send("Hello via SMS");

        Notification push = NotificationFactory.createNotification("push");

        push.send("Hello via Push");

    }

}

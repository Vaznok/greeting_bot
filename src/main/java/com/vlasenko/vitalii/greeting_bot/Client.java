package com.vlasenko.vitalii.greeting_bot;

import java.time.LocalTime;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        GreetingHandler greetingHandler = new GreetingHandlerImpl(new GreetingMessengerImpl());
        String greetingMsg = greetingHandler.getGreetingByTime(LocalTime.now());
        System.out.println(greetingMsg);
        Thread.sleep(5000);
    }
}

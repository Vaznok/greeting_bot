package com.vlasenko.vitalii.greeting_bot;

import java.time.LocalTime;

public class ClientGreeting {
    public static void main(String[] args) throws InterruptedException {
        GreetingManager manager = new GreetingManagerImpl(new GreetingMessengerImpl());
        String message = manager.getGreetingByTime(LocalTime.now());
        System.out.println(message);
        Thread.sleep(5000);
    }
}

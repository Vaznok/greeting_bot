package com.vlasenko.vitalii.greeting_bot;

public class Client {
    public static void main(String[] args) {
        GreetingManager greetingManager = new GreetingManagerImpl(new GreetingBotImpl());
        greetingManager.doGreeting();
    }
}

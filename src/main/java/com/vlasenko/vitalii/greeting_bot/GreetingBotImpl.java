package com.vlasenko.vitalii.greeting_bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.ResourceBundle;

public class GreetingBotImpl implements GreetingBot {
    private static Logger logger = LoggerFactory.getLogger(GreetingBotImpl.class.getSimpleName());

    private static final Locale locale = new Locale(System.getProperty("user.language"));
    private static final ResourceBundle messages = ResourceBundle.getBundle("i18n.messages", locale);

    @Override
    public void morningGreetings() {
        String msg = messages.getString("greeting-morning");
        System.out.println(msg);
        logger.info(String.format("morning greetings executed. locale=%s, message=%s", locale, msg));
    }

    @Override
    public void dayGreetings() {
        String msg = messages.getString("greeting-day");
        System.out.println(msg);
        logger.info(String.format("day greetings executed. locale=%s, message=%s", locale, msg));
    }

    @Override
    public void eveningGreetings() {
        String msg = messages.getString("greeting-evening");
        System.out.println(msg);
        logger.info(String.format("evening greetings executed. locale=%s, message=%s", locale, msg));
    }

    @Override
    public void nightGreetings() {
        String msg = messages.getString("greeting-night");
        System.out.println(msg);
        logger.info(String.format("night greetings executed. locale=%s, message=%s", locale, msg));
    }
}

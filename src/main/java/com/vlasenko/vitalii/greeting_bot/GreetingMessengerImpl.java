package com.vlasenko.vitalii.greeting_bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class GreetingMessengerImpl implements GreetingMessenger {
    private static Logger logger = LoggerFactory.getLogger(GreetingMessengerImpl.class.getSimpleName());

    static {
        Locale.setDefault(Locale.ENGLISH);

    }

    private Locale locale;
    private ResourceBundle messages;

    public GreetingMessengerImpl() {
        String languageTag = Objects.requireNonNullElse(System.getProperty("user.language"), "en");
        this.locale  = Locale.forLanguageTag(languageTag);
        this.messages = ResourceBundle.getBundle("i18n.messages", this.locale);
    }

    public GreetingMessengerImpl(Locale locale) {
        this.locale = Objects.requireNonNull(locale);
        this.messages = ResourceBundle.getBundle("i18n.messages", this.locale);
    }

    @Override
    public String getMorningGreeting() {
        String msg = messages.getString("greeting-morning");
        logger.info(getLoggerMessage("Morning", msg));
        return msg;
    }

    @Override
    public String getDayGreeting() {
        String msg = messages.getString("greeting-day");
        logger.info(getLoggerMessage("Day", msg));
        return msg;
    }

    @Override
    public String getEveningGreeting() {
        String msg = messages.getString("greeting-evening");
        logger.info(getLoggerMessage("Evening", msg));
        return msg;
    }

    @Override
    public String getNightGreeting() {
        String msg = messages.getString("greeting-night");
        logger.info(getLoggerMessage("Night", msg));
        return msg;
    }

    private String getLoggerMessage(String dayPeriod, String greetingMsg) {
        return String.format("%s greeting locale=%s, message=%s", dayPeriod, locale, greetingMsg);
    }
}

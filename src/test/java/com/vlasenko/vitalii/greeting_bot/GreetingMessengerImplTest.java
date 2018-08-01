package com.vlasenko.vitalii.greeting_bot;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class GreetingMessengerImplTest {

    @Test
    public void correctMessageForEnglishLocale() {
        GreetingMessenger greetingMessenger = new GreetingMessengerImpl(Locale.ENGLISH);

        Assert.assertEquals(greetingMessenger.getMorningGreeting(), "Good morning, World!");
        Assert.assertEquals(greetingMessenger.getDayGreeting(), "Good day, World!");
        Assert.assertEquals(greetingMessenger.getEveningGreeting(), "Good evening, World!");
        Assert.assertEquals(greetingMessenger.getNightGreeting(), "Good night, World!");
    }

    @Test
    public void correctMessageForRussianLocale() {
        GreetingMessenger greetingMessenger = new GreetingMessengerImpl(Locale.forLanguageTag("ru"));

        Assert.assertEquals(greetingMessenger.getMorningGreeting(), "Доброе утро, Мир!");
        Assert.assertEquals(greetingMessenger.getDayGreeting(), "Добрый день, Мир!");
        Assert.assertEquals(greetingMessenger.getEveningGreeting(), "Добрый вечер, Мир!");
        Assert.assertEquals(greetingMessenger.getNightGreeting(), "Доброй ночи, Мир!");
    }

    @Test
    public void englishCorrectMessageForUntranslatedLocale() {
        GreetingMessenger greetingMessenger = new GreetingMessengerImpl(Locale.KOREAN);

        Assert.assertEquals(greetingMessenger.getMorningGreeting(), "Good morning, World!");
        Assert.assertEquals(greetingMessenger.getDayGreeting(), "Good day, World!");
        Assert.assertEquals(greetingMessenger.getEveningGreeting(), "Good evening, World!");
        Assert.assertEquals(greetingMessenger.getNightGreeting(), "Good night, World!");
    }
}

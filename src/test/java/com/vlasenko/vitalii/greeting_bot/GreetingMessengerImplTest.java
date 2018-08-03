package com.vlasenko.vitalii.greeting_bot;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class GreetingMessengerImplTest {

    @Test
    public void correctMessageForEnglishLocale() {
        GreetingMessenger messenger = new GreetingMessengerImpl(Locale.ENGLISH);

        Assert.assertEquals(messenger.getMorningGreeting(), "Good morning, World!");
        Assert.assertEquals(messenger.getDayGreeting(), "Good day, World!");
        Assert.assertEquals(messenger.getEveningGreeting(), "Good evening, World!");
        Assert.assertEquals(messenger.getNightGreeting(), "Good night, World!");
    }

    @Test
    public void correctMessageForRussianLocale() {
        GreetingMessenger messenger = new GreetingMessengerImpl(Locale.forLanguageTag("ru"));

        Assert.assertEquals(messenger.getMorningGreeting(), "Доброе утро, Мир!");
        Assert.assertEquals(messenger.getDayGreeting(), "Добрый день, Мир!");
        Assert.assertEquals(messenger.getEveningGreeting(), "Добрый вечер, Мир!");
        Assert.assertEquals(messenger.getNightGreeting(), "Доброй ночи, Мир!");
    }

    @Test
    public void englishCorrectMessageForUntranslatedLocale() {
        GreetingMessenger messenger = new GreetingMessengerImpl(Locale.KOREAN);

        Assert.assertEquals(messenger.getMorningGreeting(), "Good morning, World!");
        Assert.assertEquals(messenger.getDayGreeting(), "Good day, World!");
        Assert.assertEquals(messenger.getEveningGreeting(), "Good evening, World!");
        Assert.assertEquals(messenger.getNightGreeting(), "Good night, World!");
    }
}

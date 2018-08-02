package com.vlasenko.vitalii.greeting_bot;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

import static com.vlasenko.vitalii.greeting_bot.GreetingHandlerImpl.*;

public class GreetingHandlerImplTest {
    private GreetingMessenger messenger = new GreetingMessengerImpl();
    private GreetingHandler handler = new GreetingHandlerImpl(messenger);

    @Test
    public void correctMethodInvocationForMorningBoundaryValues () {
        //MORNING_START is minimum boundary value
        Assert.assertEquals(handler.getGreetingByTime(MORNING_START), messenger.getMorningGreeting());

        //MORNING_END is strictly higher '>' boundary value. That is why 1 nanosecond was subtracted
        Assert.assertEquals(handler.getGreetingByTime(MORNING_END.minusNanos(1)), messenger.getMorningGreeting());
    }

    @Test
    public void correctMethodInvocationForDayBoundaryValues () {
        //DAY_START is minimum boundary value
        Assert.assertEquals(handler.getGreetingByTime(DAY_START), messenger.getDayGreeting());

        //DAY_END is strictly higher '>' boundary value. That is why 1 nanosecond was subtracted
        Assert.assertEquals(handler.getGreetingByTime(DAY_END.minusNanos(1)), messenger.getDayGreeting());
    }

    @Test
    public void correctMethodInvocationForEveningBoundaryValues () {
        //EVENING_START is minimum boundary value
        Assert.assertEquals(handler.getGreetingByTime(EVENING_START), messenger.getEveningGreeting());

        //EVENING_END is strictly higher '>' boundary value. That is why 1 nanosecond was subtracted
        Assert.assertEquals(handler.getGreetingByTime(EVENING_END.minusNanos(1)), messenger.getEveningGreeting());
    }

    @Test
    public void correctMethodInvocationForNightBoundaryValues () {
        //NIGHT_START is minimum boundary value
        Assert.assertEquals(handler.getGreetingByTime(NIGHT_START), messenger.getNightGreeting());

        //NIGHT period has transition to the new day. That is why we test last second of the day after start
        LocalTime nightEnd = LocalTime.parse("23:59:59");
        Assert.assertEquals(handler.getGreetingByTime(nightEnd), messenger.getNightGreeting());

        //NIGHT period has transition to the new day. That is why we test the first second of the new day before end
        LocalTime newDay = LocalTime.parse("00:00:00");
        Assert.assertEquals(handler.getGreetingByTime(newDay), messenger.getNightGreeting());

        //NIGHT_END is strictly higher '>' boundary value. That is why 1 nanosecond was subtracted
        Assert.assertEquals(handler.getGreetingByTime(NIGHT_END.minusNanos(1)), messenger.getNightGreeting());
    }
}

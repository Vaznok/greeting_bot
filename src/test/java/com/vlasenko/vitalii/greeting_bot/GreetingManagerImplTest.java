package com.vlasenko.vitalii.greeting_bot;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

import static com.vlasenko.vitalii.greeting_bot.GreetingManagerImpl.*;

public class GreetingManagerImplTest {
    private final static GreetingMessenger messenger = new GreetingMessengerImpl();
    private final static GreetingManager manager = new GreetingManagerImpl(messenger);

    @Test
    public void correctMethodInvocationForMorningBoundaryValues () {
        //MORNING_START is minimum boundary value
        Assert.assertEquals(manager.getGreetingByTime(MORNING_START), messenger.getMorningGreeting());

        //MORNING_END is strictly higher '>' boundary value. That is why 1 nanosecond was subtracted
        Assert.assertEquals(manager.getGreetingByTime(MORNING_END.minusNanos(1)), messenger.getMorningGreeting());
    }

    @Test
    public void correctMethodInvocationForDayBoundaryValues () {
        //DAY_START is minimum boundary value
        Assert.assertEquals(manager.getGreetingByTime(DAY_START), messenger.getDayGreeting());

        //DAY_END is strictly higher '>' boundary value. That is why 1 nanosecond was subtracted
        Assert.assertEquals(manager.getGreetingByTime(DAY_END.minusNanos(1)), messenger.getDayGreeting());
    }

    @Test
    public void correctMethodInvocationForEveningBoundaryValues () {
        //EVENING_START is minimum boundary value
        Assert.assertEquals(manager.getGreetingByTime(EVENING_START), messenger.getEveningGreeting());

        //EVENING_END is strictly higher '>' boundary value. That is why 1 nanosecond was subtracted
        Assert.assertEquals(manager.getGreetingByTime(EVENING_END.minusNanos(1)), messenger.getEveningGreeting());
    }

    @Test
    public void correctMethodInvocationForNightBoundaryValues () {
        //NIGHT_START is minimum boundary value
        Assert.assertEquals(manager.getGreetingByTime(NIGHT_START), messenger.getNightGreeting());

        //NIGHT period has transition to the new day. That is why we test last second of the day after start
        LocalTime nightEnd = LocalTime.parse("23:59:59");
        Assert.assertEquals(manager.getGreetingByTime(nightEnd), messenger.getNightGreeting());

        //NIGHT period has transition to the new day. That is why we test the first second of the new day before end
        LocalTime newDay = LocalTime.parse("00:00:00");
        Assert.assertEquals(manager.getGreetingByTime(newDay), messenger.getNightGreeting());

        //NIGHT_END is strictly higher '>' boundary value. That is why 1 nanosecond was subtracted
        Assert.assertEquals(manager.getGreetingByTime(NIGHT_END.minusNanos(1)), messenger.getNightGreeting());
    }
}

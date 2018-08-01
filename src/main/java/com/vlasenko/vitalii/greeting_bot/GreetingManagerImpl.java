package com.vlasenko.vitalii.greeting_bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

public class GreetingManagerImpl implements GreetingManager {
    private static Logger logger = LoggerFactory.getLogger(GreetingManagerImpl.class.getSimpleName());

    private static final LocalTime MORNING_START = LocalTime.parse("06:00:00");
    private static final LocalTime MORNING_END = LocalTime.parse("09:00:00");

    private static final LocalTime DAY_START = LocalTime.parse("09:00:00");
    private static final LocalTime DAY_END = LocalTime.parse("19:00:00");

    private static final LocalTime EVENING_START = LocalTime.parse("19:00:00");
    private static final LocalTime EVENING_END = LocalTime.parse("23:00:00");

    private static final LocalTime NIGHT_START = LocalTime.parse("23:00:00");
    private static final LocalTime NIGHT_END = LocalTime.parse("06:00:00");

    private GreetingBot greetingBot;

    public GreetingManagerImpl(GreetingBot greetingBot) {
        this.greetingBot = greetingBot;
    }

    @Override
    public void doGreeting() {
        LocalTime localTime = LocalTime.now();
        doGreetingAccordingToTime(localTime);

    }

    void doGreetingAccordingToTime(LocalTime time) {
        if(isTimeInRange(time, MORNING_START, MORNING_END)) {
            greetingBot.morningGreetings();
        } else if (isTimeInRange(time, DAY_START, DAY_END)) {
            greetingBot.dayGreetings();
        } else if (isTimeInRange(time, EVENING_START, EVENING_END)) {
            greetingBot.eveningGreetings();
        } else if (isTimeInRange(time, NIGHT_START, NIGHT_END)) {
            greetingBot.nightGreetings();
        } else {
            logger.warn("Unacceptable behavior for greeting process when time=" + time);
            throw new IllegalStateException("Unacceptable behavior for greeting process when time=" + time);
        }
    }

    private boolean isTimeInRange(LocalTime checkingTime, LocalTime start, LocalTime end) {
        return checkingTime.isAfter(start) && checkingTime.isBefore(end);
    }
}

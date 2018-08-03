package com.vlasenko.vitalii.greeting_bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

public class GreetingManagerImpl implements GreetingManager {
    private final static Logger logger = LoggerFactory.getLogger(GreetingManagerImpl.class.getSimpleName());

    static final LocalTime MORNING_START = LocalTime.parse("06:00:00");
    static final LocalTime MORNING_END = LocalTime.parse("09:00:00");

    static final LocalTime DAY_START = LocalTime.parse("09:00:00");
    static final LocalTime DAY_END = LocalTime.parse("19:00:00");

    static final LocalTime EVENING_START = LocalTime.parse("19:00:00");
    static final LocalTime EVENING_END = LocalTime.parse("23:00:00");

    static final LocalTime NIGHT_START = LocalTime.parse("23:00:00");
    static final LocalTime NIGHT_END = LocalTime.parse("06:00:00");

    private GreetingMessenger messenger;

    GreetingManagerImpl(GreetingMessenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public String getGreetingByTime(LocalTime time) {
        if(isTimeInRange(time, MORNING_START, MORNING_END)) {
            return messenger.getMorningGreeting();
        } else if (isTimeInRange(time, DAY_START, DAY_END)) {
            return messenger.getDayGreeting();
        } else if (isTimeInRange(time, EVENING_START, EVENING_END)) {
            return messenger.getEveningGreeting();
        } else if (isTimeInRangeForNight(time, NIGHT_START, NIGHT_END)) {
            return messenger.getNightGreeting();
        } else {
            logger.warn("Unacceptable behavior for greeting process when time=" + time);
            throw new IllegalStateException("Unacceptable behavior for greeting process when time=" + time);
        }
    }

    //for time period with the same day
    private boolean isTimeInRange(LocalTime checkingTime, LocalTime start, LocalTime end) {
        return (checkingTime.isAfter(start) || checkingTime.equals(start)) && checkingTime.isBefore(end);
    }

    //for time period with transition to the new day
    private boolean isTimeInRangeForNight(LocalTime checkingTime, LocalTime nightStart, LocalTime nightEnd) {
        boolean isInTheCurrentDay = (checkingTime.isAfter(nightStart) || checkingTime.equals(nightStart));
        LocalTime nextDayStart = LocalTime.parse("00:00:00");
        boolean isInTheNextDay = (checkingTime.isAfter(nextDayStart) || checkingTime.equals(nextDayStart)) && checkingTime.isBefore(nightEnd);
        return isInTheCurrentDay || isInTheNextDay;
    }
}

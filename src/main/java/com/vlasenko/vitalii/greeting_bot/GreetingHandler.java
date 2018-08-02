package com.vlasenko.vitalii.greeting_bot;

import java.time.LocalTime;

public interface GreetingHandler {
    String getGreetingByTime(LocalTime time);
}

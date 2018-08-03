package com.vlasenko.vitalii.greeting_bot;

import java.time.LocalTime;

public interface GreetingManager {
    String getGreetingByTime(LocalTime time);
}

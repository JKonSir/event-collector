package com.mase.eventcollector;

public interface EventCollector {

    void logEvent(long eventTime);

    long lastMinuteCount();

    long lastHourCount();

    long lastDayCount();

}

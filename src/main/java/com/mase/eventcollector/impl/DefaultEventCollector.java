package com.mase.eventcollector.impl;

import com.mase.eventcollector.EventCollector;
import com.mase.eventcollector.EventStorage;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DefaultEventCollector implements EventCollector {

    private final EventStorage eventStorage;

    public DefaultEventCollector(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    public void logEvent(long eventTime) {
        this.eventStorage.store(eventTime);
    }

    public long lastMinuteCount() {
        return this.eventStorage.countByOffset(Instant.now()
                .minus(1, ChronoUnit.MINUTES)
                .toEpochMilli());
    }

    public long lastHourCount() {
        return this.eventStorage.countByOffset(Instant.now()
                .minus(1, ChronoUnit.HOURS)
                .toEpochMilli());
    }

    public long lastDayCount() {
        return this.eventStorage.countByOffset(Instant.now()
                .minus(1, ChronoUnit.DAYS)
                .toEpochMilli());
    }
}

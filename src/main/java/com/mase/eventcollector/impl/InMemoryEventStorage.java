package com.mase.eventcollector.impl;

import com.mase.eventcollector.EventStorage;

import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.LongAdder;

public class InMemoryEventStorage implements EventStorage {

    private final ConcurrentSkipListMap<Long, LongAdder> storage;

    public InMemoryEventStorage() {
        this.storage = new ConcurrentSkipListMap<>(Comparator.comparingLong(v -> v));
    }

    public void store(long eventTime) {
        storage.computeIfAbsent(eventTime, k -> new LongAdder()).increment();
    }

    public long countByOffset(long offset) {
        return this.storage.tailMap(offset)
                .entrySet()
                .stream()
                .mapToLong(entry -> entry.getValue().sum())
                .sum();
    }
}

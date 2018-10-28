package com.mase.eventcollector;

public interface EventStorage {
    void store(long eventTime);
    long countByOffset(long offset);
}

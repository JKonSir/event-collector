package com.mase.eventcollector;

/*
 * Provide event storage methods
 */
public interface EventStorage {

    /*
     * Store event when event occur
     * @param eventTime
     */
    void store(long eventTime);

    /*
     * Fetch amount of events for specific offset
     * @param offset
     * @return amount
     */
    long countByOffset(long offset);
}

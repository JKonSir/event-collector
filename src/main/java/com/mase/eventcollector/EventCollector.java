package com.mase.eventcollector;

/*
 * Interface than provides basic method for logging and fetching events
 */
public interface EventCollector {

    /*
     * Log event
     * @param eventTime
     */
    void logEvent(long eventTime);

    /*
     * Fetch amount of events for last minute
     * @return amount
     */
    long lastMinuteCount();

    /*
     * Fetch amount of events for last hour
     * @return amount
     */
    long lastHourCount();

    /*
     * Fetch amount of events for last day
     * @return amount
     */
    long lastDayCount();

}

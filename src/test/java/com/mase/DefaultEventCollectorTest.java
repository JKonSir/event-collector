package com.mase;

import com.mase.eventcollector.impl.DefaultEventCollector;
import com.mase.eventcollector.EventCollector;
import com.mase.eventcollector.impl.InMemoryEventStorage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Instant;

import static org.testng.AssertJUnit.assertEquals;

public class DefaultEventCollectorTest {

    private EventCollector collector;

    @BeforeClass
    public void setUp() {
        collector = new DefaultEventCollector(new InMemoryEventStorage());
    }

    @Test(threadPoolSize = 10, invocationCount = 10000)
    public void putTest() {
        collector.logEvent(Instant.now().toEpochMilli());
    }

    @AfterClass
    public void tearDown() {
        assertEquals(10000, collector.lastMinuteCount());
        assertEquals(10000, collector.lastHourCount());
        assertEquals(10000, collector.lastDayCount());
    }
}

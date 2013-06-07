package org.jclarity.thread_pool_sizes.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jclarity.thread_pool_sizes.service.TimepointFactory;
import org.junit.Test;

public class TimepointFactoryTest {

    @Test
    public void nowDefaultsToLondon() {
        assertEquals("Europe/London", TimepointFactory.now().getZoneId());
    }

    @Test(expected=IllegalArgumentException.class)
    public void badTimezoneExceptions() {
        TimepointFactory.now("nonsense");
    }

    @Test
    public void timeZonesAffectOutput() {
        assertEquals("Pacific/Apia", TimepointFactory.now("Pacific/Apia").getZoneId());
    }

    @Test
    public void generatesSaneJson() {
        String asString = TimepointFactory.now("Pacific/Apia").toString();
        assertTrue(asString.contains("{\"epochMillis\":"));
        assertTrue(asString.contains(",\"zoneId\":\"Pacific/Apia\",\"formattedString\":"));
        assertTrue(asString.endsWith("\"}"));
    }

}

package org.jclarity.thread_pool_sizes.service;

import java.io.IOException;

import javax.annotation.concurrent.Immutable;

import org.codehaus.jackson.map.ObjectMapper;

@Immutable
public final class Timepoint {

    private static final ObjectMapper mapper = new ObjectMapper();

    private final long epochMillis;
    private final String zoneId;
    private final String formattedString;

    Timepoint(long epochMillis, String zoneId, String formattedString) {
        this.epochMillis = epochMillis;
        this.zoneId = zoneId;
        this.formattedString = formattedString;
    }

    public long getEpochMillis() {
        return epochMillis;
    }

    public String getZoneId() {
        return zoneId;
    }

    public String getFormattedString() {
        return formattedString;
    }

    @Override
    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

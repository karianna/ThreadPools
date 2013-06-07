package org.jclarity.thread_pool_sizes.service;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class TimepointFactory {

    public static Timepoint now() {
        return of(DateTime.now());
    }

    public static Timepoint now(String zoneId) {
        return of(DateTime.now(DateTimeZone.forID(zoneId)));
    }

    private static Timepoint of(DateTime dateTime) {
        long epochMillis = dateTime.getMillis();
        String zoneId = dateTime.getZone().getID();
        String formattedString = dateTime.toString();
        return new Timepoint(epochMillis, zoneId, formattedString);
    }

    public static void main(String[] args) {
        DateTime dateTime = new DateTime();

        System.out.println(dateTime);
    }

}

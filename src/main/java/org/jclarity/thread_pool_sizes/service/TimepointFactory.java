package org.jclarity.thread_pool_sizes.service;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class TimepointFactory {

    public static ReplyMessage now() {
        return of(DateTime.now());
    }

    public static ReplyMessage now(String zoneId) {
        return of(DateTime.now(DateTimeZone.forID(zoneId)));
    }

    private static ReplyMessage of(DateTime dateTime) {
        long epochMillis = dateTime.getMillis();
        String zoneId = dateTime.getZone().getID();
        String formattedString = dateTime.toString();
        long fibonacci = fibonacci(40);
        return new ReplyMessage(epochMillis, fibonacci, zoneId, formattedString);
    }

    public static long fibonacci(long n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        DateTime dateTime = new DateTime();

        System.out.println(dateTime);
    }

}

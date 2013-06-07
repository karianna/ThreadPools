package org.jclarity.thread_pool_sizes.analysis;

public class ResponseTimer {

    private long count = 0;
    private double averageTimeTaken;

    public Timer start() {
        return new Timer(this);
    }

    void addTimeTaken(long timeTaken) {
        if (firstTime()) {
            averageTimeTaken = timeTaken;
        } else {
            averageTimeTaken = (averageTimeTaken * count + timeTaken) / (count + 1);
        }

        if (shouldReset()) {
            System.out.println(averageTimeTaken);
            count = 0;
        } else {
            count++;
        }
    }

    private boolean firstTime() {
        return count == 0;
    }

    private boolean shouldReset() {
        return count == 9;
    }

}

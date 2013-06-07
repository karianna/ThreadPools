package org.jclarity.thread_pool_sizes.analysis;

public class ResponseTimer {

    private static final int FIRST_WINDOW = -1;

    private static final long WINDOW_LENGTH_IN_MS = 10_000;

    private long count = 0;
    private double averageLatency;

    private long windowStart = FIRST_WINDOW;
    private long windowCount = 0;

    public Timer start() {
        return new Timer(this);
    }

    void addTimeTaken(long timeTaken) {
        updateLatencies(timeTaken);
        resetLatencies();
        updateThroughput();
    }

    private void resetLatencies() {
        if (shouldResetLatencies()) {
            System.out.println("Latency: " + averageLatency);
            count = 0;
        } else {
            count++;
        }
    }

    private void updateLatencies(long timeTaken) {
        if (firstTime()) {
            averageLatency = timeTaken;
        } else {
            averageLatency = (averageLatency * count + timeTaken) / (count + 1);
        }
    }

    private void updateThroughput() {
        long currentTime = System.currentTimeMillis();
        windowCount++;
        if (windowStart == FIRST_WINDOW) {
            windowStart = currentTime;
        } else if (shouldResetThroughput(currentTime)) {
            System.out.println("Count: " + windowCount);
            windowCount = 0;
            windowStart = currentTime;
        }
    }

    private boolean shouldResetThroughput(long currentTime) {
        return (currentTime - windowStart) > WINDOW_LENGTH_IN_MS;
    }

    private boolean firstTime() {
        return count == 0;
    }

    private boolean shouldResetLatencies() {
        return count == 9;
    }

}

package org.jclarity.thread_pool_sizes.analysis;


public final class Timer {

    private final long startTime;
    private final ResponseTimer times;

    Timer(ResponseTimer times) {
        this.times = times;
        startTime = System.nanoTime();
    }

    public void stop() {
        times.addTimeTaken(System.nanoTime() - startTime);
    }

}

package com.suku.thread.method;

import java.util.logging.Logger;

/**
 * When we invoke the join() method on a thread, the calling thread goes into a waiting state.
 * It remains in a waiting state until the referenced thread terminates.
 */
public class ThreadJoin extends java.lang.Thread {
    private static final Logger LOGGER = Logger.getLogger("abc");
    public int processingCount = 0;
    ThreadJoin(int processingCount) {
        this.processingCount = processingCount;
        LOGGER.info("Thread Created");
    }

    @Override
    public void run() {
        LOGGER.info("Thread " + this.getName() + " started");
        while (processingCount > 0) {
            try {
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.info("Thread " + this.getName() + " interrupted");
            }
            processingCount--;
        }
        LOGGER.info("Thread " + this.getName() + " exiting");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new ThreadJoin(5);
        t2.start();
        LOGGER.info("Invoking join");
        t2.join();
        LOGGER.info("Returned from join");
        LOGGER.info(String.valueOf(t2.isAlive()));
    }
}

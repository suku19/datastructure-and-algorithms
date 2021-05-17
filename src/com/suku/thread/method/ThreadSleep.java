package com.suku.thread.method;

/**
 * Based on the requirement we can make a thread to be in sleeping state for a specified period of time
 *
 * Sleep() causes the thread to definitely stop executing for a given amount of time; if no other thread
 * or process needs to be run, the CPU will be idle (and probably enter a power saving mode).
 */
public class ThreadSleep implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadSleep());
        t.start();

        Thread t1 = new Thread(new ThreadSleep());
        t1.start();

    }
}
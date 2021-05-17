package com.suku.thread.concurrent.lock;

import com.suku.thread.concurrent.ConcurrentUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchronizedLockExample {
    private int count = 0;

    void increment() {
        count = count + 1;
    }

    synchronized void incrementSync() {
        count = count+1;
    }

    public void processor(ExecutorService service) {
        IntStream.range(0, 10000).forEach(i -> service.submit(this::increment));
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedLockExample obj = new SynchronizedLockExample();
        ExecutorService service = Executors.newFixedThreadPool(2);
        obj.processor(service);
        ConcurrentUtils.stop(service);
        System.out.println(obj.count);

    }
}

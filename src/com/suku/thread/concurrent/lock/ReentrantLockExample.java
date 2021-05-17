package com.suku.thread.concurrent.lock;

import com.suku.thread.concurrent.ConcurrentUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockExample {
    ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    void increment() {
        count = count + 1;
    }

    void incrementLock() {
        lock.lock();
        try {
            count = count + 1;
        } finally {
            lock.unlock();
        }
    }

    public void processor(ExecutorService service) {
        IntStream.range(0, 10000).forEach(i -> service.submit(this::incrementLock));
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample obj = new ReentrantLockExample();
        ExecutorService service = Executors.newFixedThreadPool(2);
        obj.processor(service);
        ConcurrentUtils.stop(service);
        System.out.println(obj.count);

        // Locks support various methods for fine grained control
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock();
        executor.submit(() -> {
            lock.lock();
            try {
                ConcurrentUtils.sleep(1);
            } finally {
                lock.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });
        ConcurrentUtils.stop(executor);
    }
}

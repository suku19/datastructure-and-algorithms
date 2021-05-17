package com.suku.thread.concurrent.lock;

import com.suku.thread.concurrent.ConcurrentUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

public class ReadWriteLockExample {
    private static final Logger LOGGER = Logger.getLogger("ReadWriteLockExample");

    ExecutorService executor = Executors.newFixedThreadPool(5);
    Map<String, String> map = new HashMap<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    void put(String key, String value) {
        lock.writeLock().lock();
        try {
            ConcurrentUtils.sleep(1);
            map.put(key,value);
        }finally {
            lock.writeLock().unlock();
        }
    }

    String get(String key) {
        lock.readLock().lock();
        try {
            ConcurrentUtils.sleep(1);
            return map.get(key);
        }finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample obj = new ReadWriteLockExample();
        obj.executor.submit(() -> {
            obj.put("foo","bar");
            System.out.println("Putting Data <=> "+ LocalDateTime.now());
        });
        obj.executor.execute(() -> {
            System.out.println(obj.get("foo") +" <-> "+ LocalDateTime.now());
        });
        obj.executor.execute(() -> {
            System.out.println(obj.get("foo") +" <-> "+ LocalDateTime.now());
        });

        ConcurrentUtils.stop(obj.executor);
    }
}

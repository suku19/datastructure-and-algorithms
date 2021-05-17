package com.suku.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfo {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            service.execute(() -> System.out.println("Printing zoo inventory."));
            service.execute(() -> {
                for (int i = 0; i < 3; i++)
                    System.out.println("Printing Record: " + i);
            });
            service.execute(() -> System.out.println("Printing zoo inventory."));
            System.out.println("end");
        } finally {
            if(service != null)
                service.shutdown();
        }
    }
}

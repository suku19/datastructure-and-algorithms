package com.suku.thread.concurrent;

import java.util.concurrent.*;

public class CheckResults {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 500; i++) CheckResults.counter++;
            });
            System.out.println(result.isDone());
            result.get(10, TimeUnit.SECONDS);
            System.out.println(result.isDone());
            System.out.println("Reached!"+counter);
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if (service != null) service.shutdown();
        }
    }
}

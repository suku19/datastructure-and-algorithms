package com.suku.thread.concurrent.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {
    private void removeAnimals() { System.out.println("Removing animals"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addAnimals() { System.out.println("Adding animals"); }
    public void performTask() {
        removeAnimals();
        cleanPen();
        addAnimals();
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c1.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
// Handle checked exceptions here
        }
    }
    public static void main(String[] args) {
        System.out.println("withoutBarrier ===========>");
        withoutBarrier();
        System.out.println("with Barrier ===========>");
        withBarrier();
    }

    /**
     * within a single thread the results are ordered, among multiple workers the
     * output is entirely random.
     */
    public static void withoutBarrier() {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            for(int i=0; i<4; i++)
                service.submit(() -> manager.performTask());
        } finally {
            if(service != null) service.shutdown();
        }
    }

    /**
     * The CyclicBarrier
     * takes in its constructors a limit value, indicating the number of threads to wait for. As each
     * thread finishes, it calls the await() method on the cyclic barrier. Once the specified number
     * of threads have each called await(), the barrier is released and all threads can continue.
     */
    private static void withBarrier() {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4,
                    () -> System.out.println("*** Pen Cleaned!"));
            for(int i=0; i<4; i++)
                service.submit(() -> manager.performTask(c1,c2));
        } finally {
            if(service != null) service.shutdown();
        }
    }
}

package com.suku.thread.method;

// MyThread extending Thread
class MyThread extends java.lang.Thread {
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println(java.lang.Thread.currentThread().getName()
                    + " in control");
    }
}

/**
 * Once a thread has executed yield method and there are many threads with same priority is waiting for processor,
 * then we can't specify which thread will get execution chance first.
 *
 * The thread which executes the yield method will enter in the Runnable state from Running state.
 *
 * Once a thread pauses its execution, we can't specify when it will get chance again it depends on thread scheduler.
 *
 * Underlying platform must provide support for preemptive scheduling if we are using yield method.
 */
public class ThreadYield {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

        for (int i = 0; i < 5; i++) {
            // Control passes to child thread
            java.lang.Thread.yield();

            // After execution of child Thread
            // main thread takes over
            System.out.println(java.lang.Thread.currentThread().getName()
                    + " in control");
        }
    }
}
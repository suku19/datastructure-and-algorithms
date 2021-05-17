package com.suku.thread.waitnotify;

/**
 * It tells the calling thread to give up the lock and go to
 * sleep until some other thread enters the same monitor
 * and calls notify().
 *
 * The wait() method releases the lock prior to waiting
 * and reacquires the lock prior to returning from the
 * wait() method.
 */
public class Waiter implements Runnable{
    private Message msg;

    public Waiter(Message m) {
        this.msg = m;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try{
                System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
                msg.wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
            //process the message now
            System.out.println(name+" processed: "+msg.getMsg());
        }
    }
}

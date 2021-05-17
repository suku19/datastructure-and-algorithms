package com.suku.thread;

import java.util.Random;

class SharedClass{
    SharedClass(String msg) {
        this.msg = msg;
    }
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
public class ThreadLocalExample implements Runnable{

    //java prior to 8
    /*private static final ThreadLocal<SharedClass> threadLocal = new ThreadLocal(){
        @Override
        protected SharedClass initialValue() {
            return new SharedClass("Default value");
        }
    };*/

    //java 8
    private static final ThreadLocal<SharedClass> threadLocal = ThreadLocal.withInitial(() -> {return new SharedClass("Welcome");});



    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default message = "+threadLocal.get().getMsg());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadLocal.set(new SharedClass("message 2"));
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" changed message = "+threadLocal.get().getMsg());

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for(int i=0; i<10;i++) {
            Thread t = new Thread(threadLocalExample, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
        System.out.println("com.suku.tree.Main Finished");
    }
}

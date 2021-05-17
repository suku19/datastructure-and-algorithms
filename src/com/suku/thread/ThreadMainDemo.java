package com.suku.thread;

public class ThreadMainDemo extends java.lang.Thread {

    public void run(){
        try {
            ThreadMainDemo.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" Finished");
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadMainDemo t1 = new ThreadMainDemo();
        t1.start();

        ThreadMainDemo t2 = new ThreadMainDemo();
        t2.start();
        t1.join();

        System.out.println("com.suku.tree.Main finished");
//        while(true) {
//            System.out.println(new Random ().nextInt(100));
//        }
    }
}



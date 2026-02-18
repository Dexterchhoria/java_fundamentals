package com.siddharth.multithreading;

// start , run , sleep , join , setPriority

public class MyThread extends Thread {
//    @Override
//    public void run() {
//        for(int i =1;i<=5;i++){
//            try {
//                Thread.sleep(1000);     // try catch lgana hoga
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);
//        }


    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - priority " + Thread.currentThread().getPriority() + " - count: " + i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new MyThread();
//        t1.start();
//        System.out.println("hello1");
//        t1.join();   // exception aayega toh throw krna hoga  ... intezar krega t1 khatam hone ka
//        System.out.println("hello2");
        MyThread l = new MyThread("Low priority thread");
        MyThread m = new MyThread("Medium  priority thread");
        MyThread h = new MyThread("High priority thread");
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);
        l.start();
        m.start();
        h.start();
    }
}

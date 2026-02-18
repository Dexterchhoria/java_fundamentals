package com.siddharth.multithreading;

public class MultithreadingExample extends Thread{
    @Override
    public void run(){
        System.out.println("running");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultithreadingExample t1 = new MultithreadingExample();  // new
        System.out.println(t1.getState());
        t1.start();                                // runnable
        System.out.println(t1.getState());
        Thread.sleep(100);
        System.out.println(t1.getState());   // Timed_waiting
        t1.join();                          // Terminated
        System.out.println(t1.getState());
//        System.out.println(Thread.currentThread().getState());  // runnable

    }
}

package com.example.demo.threads;

public class ThreadEx {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();      // when we use start() method it creates new thread and Executes concurrently called by JVM
        // when we use run() no method creates and no concurrently called by current thread
        thread1.start();
    }                                            // By extending Thread class and Implementing Runnable interface
}
                                                    //New
class Thread1 extends Thread {                     //Runnable
                                                    //Running
                                                    //Terminating
    @Override
    public void run() {
        System.out.println("Run method started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread Started");
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread started again");
    }
}
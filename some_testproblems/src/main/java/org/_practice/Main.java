package org._practice;

public class Main {
    public static void main(String[] args) {
        // Creating a thread using Runnable interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " - Count: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        
        // Creating and starting threads
        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");
        
        thread1.start();
        thread2.start();
    }
}

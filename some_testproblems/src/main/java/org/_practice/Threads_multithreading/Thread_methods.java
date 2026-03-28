package org._practice.Threads_multithreading;

public class Thread_methods {
    
    public static void main(String[] args) throws InterruptedException {
        // Create thread 1
        Thread thread1 = new Thread(new MyRunnable("Thread 1"), "Thread-1");
        
        // Create thread 2
        Thread thread2 = new Thread(new MyRunnable("Thread 2"), "Thread-2");
        
        // Get thread information
        System.out.println("Thread 1 ID: " + thread1.getId());
        System.out.println("Thread 1 Name: " + thread1.getName());
        System.out.println("Thread 1 Priority: " + thread1.getPriority());
        System.out.println("Thread 1 State: " + thread1.getState());
        
        // Start threads
        thread1.start();
        thread2.start();
        
        // Check if threads are alive
        System.out.println("\nThread 1 alive: " + thread1.isAlive());
        
        // Wait for thread1 to complete
        thread1.join();
        System.out.println("Thread 1 completed");
        
        // Set priority for thread2
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.join();
        System.out.println("Thread 2 completed");
        
        System.out.println("\nAll threads completed");
    }
    
    static class MyRunnable implements Runnable {
        private String name;
        
        public MyRunnable(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            try {
                System.out.println(name + " started");
                Thread.sleep(1000); // Simulate work
                System.out.println(name + " ended - Current thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted");
            }
        }
    }
}

package org._practice.Threads_multithreading;


public class ThreadPriorities {
    public static void main(String[] args) {
        T1 h1 = new T1();
        Thread t1 = new Thread(h1);
        t1.setName("Thread 1");
        t1.setPriority(Thread.NORM_PRIORITY);
        System.out.println(t1.getName() + " Priority: " + t1.getPriority());

        T2 h2 = new T2();
        Thread t2 = new Thread(h2);
        t2.setName("Thread 2");
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println(t2.getName() + " Priority: " + t2.getPriority());

        T3 h3 = new T3();
        Thread t3 = new Thread(h3);
        t3.setName("Thread 3");
        t3.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t3.getName() + " Priority: " + t3.getPriority());

        t1.start();
        t2.start();
        t3.start();
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": book");
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": book in T2");
        }
    }
}

class T3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": book in T3");
        }
    }
}

package org._practice.Threads_multithreading;

//Synchronization in Threads (Race Condition Example)
//Create a program with a shared counter accessed by multiple threads. Use
//synchronization to prevent race conditions

import java.util.concurrent.locks.ReentrantLock;

public class RaaceConditionSYnchronization  extends Thread{
    static Counter obj = new Counter();

    //static ReentrantLock lock=new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {

      RaaceConditionSYnchronization t1 = new RaaceConditionSYnchronization();
        RaaceConditionSYnchronization t2 = new RaaceConditionSYnchronization();
       // lock.lock();
        t1.start();
        t2.start();
       // lock.unlock();
        t1.join();
        t2.join();

        System.out.println("Final Count: " + obj.count);
    }



    public void run() {
        obj.increments();
    }
    }

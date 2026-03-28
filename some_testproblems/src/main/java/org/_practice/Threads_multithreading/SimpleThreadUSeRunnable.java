package org._practice.Threads_multithreading;


public class SimpleThreadUSeRunnable {
    public static void main(String[] args) {
        runn r=new runn();
        Thread t1=new Thread(r);
        t1.start();
    }
}

class runn implements Runnable
{

    @Override
    public void run() {
        for(int i=0;i<=10;i++)
        {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
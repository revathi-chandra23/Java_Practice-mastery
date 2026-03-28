package org._practice.Threads_multithreading;


public class SimpleThreadUsingLAmbda extends Thread {
    public static void main(String[] args) {
        Thread t=new Thread(()->
        {
            for(int i=0;i<=10;i++)
            {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();

    }
}

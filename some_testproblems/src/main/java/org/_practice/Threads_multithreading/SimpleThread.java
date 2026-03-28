package org._practice.Threads_multithreading;

public class SimpleThread {
    public static void main(String[] args) {
        myThreads m=new myThreads();
        m.start();
    }
}
 class myThreads extends Thread
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
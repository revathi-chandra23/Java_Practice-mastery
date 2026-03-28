package org._practice.Threads_multithreading;

public class Helloworld  {
    public static void main(String[] args) {
        hello h=new hello();
        Thread t=new Thread(h);
        t.start();
    }
}
class hello implements Runnable
{

    @Override
    public void run() {
        for(int i=0;i<5;i++)
            System.out.println("hello world");
    }
}
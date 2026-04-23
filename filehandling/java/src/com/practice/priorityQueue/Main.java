package org.atyeti.blocingQueue;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(30); pq.offer(10); pq.offer(20); 

        while (!pq.isEmpty())
            System.out.println("Consumed: " + pq.poll()); 
    }
}
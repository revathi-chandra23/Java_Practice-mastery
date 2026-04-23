package org.atyeti.blocingQueue;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(30); pq.offer(10); pq.offer(20); //Producer

        while (!pq.isEmpty())
            System.out.println("Consumed: " + pq.poll()); //Consumer
    }
}
package org.atyeti.blocingQueue.priorityQueue;

import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueExampleAndMethods {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        pq.offer(5);

        System.out.println("PriorityQueue (Min-Heap): " + pq);

        System.out.println("Peek element: " + pq.peek());

        System.out.println("Removed element: " + pq.poll());

        System.out.println("After poll: " + pq);
        System.out.println("Size: " + pq.size());

        System.out.println("Is Empty: " + pq.isEmpty());

        System.out.println("Elements:");
        for (int num : pq) {
            System.out.println(num);
        }

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

        maxPQ.offer(30);
        maxPQ.offer(10);
        maxPQ.offer(20);
        maxPQ.offer(5);

        System.out.println("\nPriorityQueue (Max-Heap): " + maxPQ);

        System.out.println("Peek (Max): " + maxPQ.peek());
        System.out.println("Removed (Max): " + maxPQ.poll());
        System.out.println("After poll (Max): " + maxPQ);
    }
}
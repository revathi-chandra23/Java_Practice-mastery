package org.atyeti.blocingQueue.priorityQueue;

import java.util.PriorityQueue;

class SimpleBuffer {
    PriorityQueue<Integer> buffer = new PriorityQueue<>();
    int capacity = 5;


    void produce(int value) {
        if (buffer.size() == capacity) {
            System.out.println("Buffer Full, cannot produce " + value);
            return;
        }

        buffer.offer(value);
        System.out.println("Produced: " + value);
    }


    void consume() {
        if (buffer.isEmpty()) {
            System.out.println("Buffer Empty, nothing to consume");
            return;
        }

        int val = buffer.poll();
        System.out.println("Consumed: " + val);
    }
}

public class ProducerConsumerr {
    public static void main(String[] args) {
//consumer producer problem using priority queue
        SimpleBuffer buffer = new SimpleBuffer();


        buffer.produce(30);
        buffer.produce(10);
        buffer.produce(20);
//        buffer.produce(5);

        buffer.consume();          buffer.consume();


        buffer.produce(5);
        buffer.produce(50);

        buffer.consume();
        buffer.consume();
        buffer.consume();
    }
}
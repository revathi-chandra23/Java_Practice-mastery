package org.atyeti.blocingQueue.priorityQueue;

import java.util.PriorityQueue;

class Student {
    //
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class CustomPQ {
    public static void main(String[] args) {

        PriorityQueue<Student> pq = new PriorityQueue<>(
                (a, b) -> a.id - b.id
        );

        pq.offer(new Student(3, "Ravi"));
        pq.offer(new Student(1, "Anu"));
        pq.offer(new Student(2, "Kiran"));

        while (!pq.isEmpty()) {
            Student s = pq.poll();
            System.out.println(s.id + " " + s.name);
        }
    }
}
abstract class Vehicle {
    abstract void start(); // abstract method
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with key");
    }
}

public class car1 {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();
    }
}
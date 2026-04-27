abstract class Vehicle {
    abstract void start();
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with key");
    }
}

public class Abstraction1{
    public static void main(String[] args) {
        Vehicle v = new Bike();
        v.start();
    }
}

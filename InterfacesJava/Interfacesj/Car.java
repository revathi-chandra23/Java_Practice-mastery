interface Vehicle {
    default void start() {
        System.out.println("Vehicle starts");
    }
}

class Car implements Vehicle {
    public static void main(String[] args) {
        Car car = new Car();
        car.start(); // Calls the default method from Vehicle interface
    }
}
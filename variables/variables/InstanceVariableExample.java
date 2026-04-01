class InstanceVariableExample {

    int age;   // Instance variable (default value = 0)

    void display() {
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        InstanceVariableExample obj1 = new InstanceVariableExample();
        obj1.display();
    }
}
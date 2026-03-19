interface A {
    void show();
}

interface B {
    void display();
}

public class Mult implements A, B {
    public void show() {
        System.out.println("A method");
    }

    public void display() {
        System.out.println("B method");
    }
}
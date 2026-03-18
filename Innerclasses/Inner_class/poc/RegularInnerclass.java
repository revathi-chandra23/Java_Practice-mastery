class Outer {
    private String message = "Hello from Outer class ";

    class Inner {
        void display() {
            System.out.println(message);
        }
    }
}

public class RegularInnerclass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); 
        inner.display();
    }
}
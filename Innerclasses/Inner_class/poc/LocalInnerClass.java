class Outer {
    void show() {
        String msg = "Hello from Local Inner";

        class LocalInner {
            void display() {
                System.out.println(msg);
            }
        }

        LocalInner obj = new LocalInner();
        obj.display();
    }
}

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.show();
    }
}
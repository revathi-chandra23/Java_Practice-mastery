class Outer {
    interface Inner {
        void display();
        
    }
}
// class implementing the nested interface
public class NestedInterfaces implements Outer.Inner {
    public void display() {
        System.out.println("Nested Interface");
    }
}
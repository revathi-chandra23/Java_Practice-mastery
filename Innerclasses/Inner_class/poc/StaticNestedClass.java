
class Outer {
    static String message = "Hello from Static Nested";

    static class Nested {
        void display() {
            System.out.println(message);
        }
    }
}
public class StaticNestedClass {
   public static void main(String[] args) {
        Outer.Nested nested = new Outer.Nested(); // no outer object needed
        nested.display();
    } 
}

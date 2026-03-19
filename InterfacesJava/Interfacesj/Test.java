@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
// functional interface implementation using lambda expression

public class Test {
    public static void main(String[] args) {
        Calculator c = (a, b) -> a + b;
        System.out.println(c.add(5, 3));
    }
}
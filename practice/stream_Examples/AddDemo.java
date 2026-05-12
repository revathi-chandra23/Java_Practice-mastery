

@FunctionalInterface
interface Add {
    int addition(int a, int b);
}
public class AddDemo {
    public static void main(String[] args) {
        Add add = (a, b) -> a + b;
        System.out.println("Sum: " + add.addition(10, 20));
    }
}
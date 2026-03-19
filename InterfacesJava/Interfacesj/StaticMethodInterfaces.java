interface MathUtil {
    static int square(int x) {
        return x * x;
    }
}
// static method in interface, can be called without creating an instance of the interface
public class StaticMethodInterfaces {
    public static void main(String[] args) {
        System.out.println(MathUtil.square(4));
    }
}
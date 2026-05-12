
import java.util.Arrays;
import java.util.List;
public class LambdaStream{
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Adam");

        names.forEach(name -> System.out.println(name));

        names.stream()
                .filter(n -> n.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
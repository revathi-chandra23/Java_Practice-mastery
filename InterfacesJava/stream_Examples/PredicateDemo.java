

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java", "Python", "C");
        Function<String, Integer> length = s -> s.length();

        names.stream()
                .map(length)
                .forEach(System.out::println);


        Consumer<String> print = s -> System.out.println(s);

        names.forEach(print);

        Supplier<Double> random = () -> Math.random();

        Stream.generate(random)
                .limit(5)
                .forEach(System.out::println);

        int [] arr={1,1,2,2,3,3,4,5,6};
        System.out.println(Arrays.stream(arr).boxed().distinct().collect(Collectors.counting()));

    }
}

import java.util.Arrays;
import java.util.stream.Collectors;

public class COllec{

    public static void main(String[] args) {

        Integer count = Arrays.asList(
                "A", "B", "C"
        )
        .stream()
        .collect(Collectors.collectingAndThen(

                Collectors.counting(),

                Long::intValue
        ));

        System.out.println(count);
    }
}
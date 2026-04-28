import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIntegers {
    public static void main(String[] args) {

        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(8);
        numbers.add(3);
        numbers.add(15);
        numbers.add(1);
        numbers.add(9);
        numbers.add(4);

        // Sort in ascending order
        Collections.sort(numbers);
        numbers.sort(null); 
        System.out.println("Ascending order: " + numbers);

        // Sort in descending order
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending order: " + numbers);
    }
}
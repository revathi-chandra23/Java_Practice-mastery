import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstNethod {
    public static void main(String[] args) {
        System.out.println(java.util.stream.Stream.of(1,2,3,4,5).filter(e->e%2==0).findFirst().orElse(-1));
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

Optional<Integer> result = nums.stream()
                               .filter(n -> n % 2 == 0)
                               .findFirst();

System.out.println(result.get());
    }
    
}

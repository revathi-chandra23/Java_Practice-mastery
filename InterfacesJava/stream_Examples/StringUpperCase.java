
import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUpperCase {
    public static void main(String[] args){
        String []s={"java","python","ruby","javascript"};
        System.out.println(Arrays.stream(s).map(String::toUpperCase).collect(Collectors.toList()));
    }
}

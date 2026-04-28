import java.util.HashSet;
import java.util.Set;

public class DuplicateUsingDoWhile {

    public static void main(String[] args) {

        String str = "madam";
        char[] chars = str.toCharArray();

        Set<Character> set = new HashSet<>();

        int i = 0;
        boolean duplicateFound = false;

        do {
            if (!set.add(chars[i])) {
                System.out.println("Duplicate character found: " + chars[i]);
                duplicateFound = true;
                break;
            }
            i++;
        } while (i < chars.length);

        if (!duplicateFound) {
            System.out.println("No duplicate characters found");
        }
    }
}
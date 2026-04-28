import java.util.HashSet;
import java.util.Set;

public class DuplicateUsingHashSet {

    public static void main(String[] args) {

        String str = "madam";
        Set<Character> set = new HashSet<>();

        boolean duplicateFound = false;

        for (char ch : str.toCharArray()) {
            // add() returns false if element already exists
            if (!set.add(ch)) {
                System.out.println("Duplicate character found: " + ch);
                duplicateFound = true;
                break;
            }
        }

        if (!duplicateFound) {
            System.out.println("No duplicate characters found");
        }
    }
}
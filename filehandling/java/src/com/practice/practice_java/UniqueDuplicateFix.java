import java.util.*;
 
public class UniqueDuplicateFix {
    public static void main(String[] args) {
        String str = "madam";
 
        HashSet<Character> printed = new HashSet<>();
 
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
 
            if (str.indexOf(ch) != str.lastIndexOf(ch) && !printed.contains(ch)) {
                System.out.println("Duplicate: " + ch);
                printed.add(ch);
            }
        }
    }
}
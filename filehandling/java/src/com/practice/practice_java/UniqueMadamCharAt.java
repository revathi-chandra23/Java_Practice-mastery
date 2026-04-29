import java.util.*;
 
public class UniqueMadamCharAt {
    public static void main(String[] args) {
        String word = "madam";
 
        HashSet<String> set = new HashSet<>();
 
        for (int i = 0; i < word.length(); i++) {
            set.add(String.valueOf(word.charAt(i))); // ✅ convert
        }
 
        System.out.println("Unique characters: " + set);
    }
}
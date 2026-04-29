import java.util.*;
 
public class UDuplicateFix {

    public static void main(String[] args) {

        String word = "madam";
 
        HashSet<Character> set = new HashSet<>();
 
        for (int i = 0; i < word.length(); i++) {

            set.add(word.charAt(i)); // ✅ correct

        }
 
        System.out.println("Unique characters: " + set);

    }

}
 
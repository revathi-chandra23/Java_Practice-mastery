import java.util.*;
import java.util.stream.Collectors;
 
public class SortMapStoreOnly {
    public static void main(String[] args) {
 
        String str = "madam";
        Map<Character, Integer> map = new HashMap<>();
 
        
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
 
   
        Map<Character, Integer> sortedMap =
                map.entrySet()
                   .stream()
                   .sorted((e1, e2) -> e1.getValue() - e2.getValue())
                   .collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (e1, e2) -> e1,
                       LinkedHashMap::new
                   ));
 
        System.out.println(sortedMap);
    }
}
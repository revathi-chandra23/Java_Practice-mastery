

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramPairs {
    public static void main(String[] args) {
        List<String> li = Arrays.asList("race","below","elbow","cat","care","act","ate","eat");
        System.out.println(li.stream().collect(Collectors.groupingBy(list->Arrays.stream(list.split("")).sorted().collect(Collectors.joining()))).values().stream().filter(group->group.size()>1).toList());

        System.out.println(li.stream().filter(e->e.startsWith("e")).toList());
    }
}

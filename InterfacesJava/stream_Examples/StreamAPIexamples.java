import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIexamples {
    public static void main(String[] args) {

        //Q1. counting the ele
        int arr[] = {1,1,2,2,3,3,4,4,5,5};

        System.out.println(Arrays.stream(arr).distinct().count());
        System.out.println(Arrays.stream(arr).boxed().distinct().collect(Collectors.counting()));

        //Q2. Summing the ele

        int arr2[] ={1,2,3,4,5};

        System.out.println(Arrays.stream(arr2).sum());
// using the reduce method
        System.out.println(Arrays.stream(arr2).reduce(0,(a,b)->a+b));

        System.out.println(Arrays.stream(arr2).reduce(0,Integer::sum));

        System.out.println(Arrays.stream(arr2).boxed().collect(Collectors.summingInt(x->x)));

//Q3. Sorting the ele

        int arr3[] = {6,2,7,9,1,5,8};

        System.out.println(Arrays.stream(arr3).boxed().sorted().toList());
// for reverse order
        System.out.println(Arrays.stream(arr3).boxed().sorted(Comparator.reverseOrder()).toList());


//Q4. Sorting the string based on length
        String s1 = "I am learning stream API in java";

        System.out.println(Arrays.stream(s1.split(" ")).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()));

        // for reverse order
        System.out.println(Arrays.stream(s1.split(" ")).map(String::length).sorted().collect(Collectors.toList()));

        System.out.println(Arrays.stream(s1.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get());
// for reverse order using map method 
        System.out.println(Arrays.stream(s1.split(" ")).map(String::length).sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        System.out.println(Arrays.stream(s1.split(" ")).min(Comparator.comparingInt(String::length)).get());


        // not the vowels  in the string 
        String s = "Rohit Patil";

        System.out.println(Arrays.stream(s.split("")).map(x->x.replaceAll("[aeiouAEIOU]","")).collect(Collectors.joining()));


        String s2 = "I am learning java stream API";

        System.out.println(Arrays.stream(s2.split(" ")).filter(x->x.replaceAll("[^aeiouAEIOU]","").length()==2).toList());

// not the  duplicate characters in the string
        String s3 = "mississippi";

        System.out.println(Arrays.stream(s3.split("")).distinct().toList());

        System.out.println(Arrays.stream(s3.split("")).collect(Collectors.groupingBy(a->a,Collectors.counting())));

        // to get the duplicate characters in the string
        String s4[] = {"abc","1234","def","6789"};

        System.out.println(Arrays.stream(s4).filter(x->x.matches("[0-9]+")).map(Integer::valueOf).toList());

        int v[] = {1,2,6,9,5,8};

        System.out.println(Arrays.stream(v).boxed().sorted(Comparator.reverseOrder()).limit(2).reduce(1,(a,b)->a*b));

        // partitioning the even and odd / even numbers in the array
        int b[] = {1,2,3,4,5,6,7,8,9};

        System.out.println(Arrays.stream(b).boxed().collect(Collectors.partitioningBy(x->x%2==0)).entrySet().stream().map(Map.Entry::getValue).toList());

    }

}
 
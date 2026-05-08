import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class STreamAPI {
    public static void main(String[] args) {

        //Q1. counting the ele
        int arr[] = {1,1,2,2,3,3,4,4,5,5};

        System.out.println(Arrays.stream(arr).distinct().count());
        System.out.println(Arrays.stream(arr).boxed().distinct().collect(Collectors.counting()));

        //Q2. Summing the ele

        int arr2[] ={1,2,3,4,5};

        System.out.println(Arrays.stream(arr2).sum());

        System.out.println(Arrays.stream(arr2).reduce(0,(a,b)->a+b));

        System.out.println(Arrays.stream(arr2).reduce(0,Integer::sum));

        System.out.println(Arrays.stream(arr2).boxed().collect(Collectors.summingInt(x->x)));



        int arr3[] = {6,2,7,9,1,5,8};

        System.out.println(Arrays.stream(arr3).boxed().sorted().toList());

        System.out.println(Arrays.stream(arr3).boxed().sorted(Comparator.reverseOrder()).toList());



        String s1 = "I am learning stream API in java";

        System.out.println(Arrays.stream(s1.split(" ")).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()));

        System.out.println(Arrays.stream(s1.split(" ")).map(String::length).sorted().collect(Collectors.toList()));

        System.out.println(Arrays.stream(s1.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get());

        System.out.println(Arrays.stream(s1.split(" ")).map(String::length).sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        System.out.println(Arrays.stream(s1.split(" ")).min(Comparator.comparingInt(String::length)).get());


        String s = "Rohit Patil";

        System.out.println(Arrays.stream(s.split("")).map(x->x.replaceAll("[aeiouAEIOU]","")).collect(Collectors.joining()));


        String s2 = "I am learning java stream API";

        System.out.println(Arrays.stream(s2.split(" ")).filter(x->x.replaceAll("[^aeiouAEIOU]","").length()==2).toList());


        String s3 = "mississippi";

        System.out.println(Arrays.stream(s3.split("")).distinct().toList());

        System.out.println(Arrays.stream(s3.split("")).collect(Collectors.groupingBy(a->a,Collectors.counting())));

        String s4[] = {"abc","1234","def","6789"};

        System.out.println(Arrays.stream(s4).filter(x->x.matches("[0-9]+")).map(Integer::valueOf).toList());

        int v[] = {1,2,6,9,5,8};

        System.out.println(Arrays.stream(v).boxed().sorted(Comparator.reverseOrder()).limit(2).reduce(1,(a,b)->a*b));

        int b[] = {1,2,3,4,5,6,7,8,9};

        System.out.println(Arrays.stream(b).boxed().collect(Collectors.partitioningBy(x->x%2==0)).entrySet().stream().map(Map.Entry::getValue).toList());

        String str = "Hello world";

        System.out.println(Arrays.stream(str.split("")).filter(x->str.indexOf(x)==str.lastIndexOf(x)).findFirst().get());

        System.out.println(Arrays.stream(str.split("")).collect(Collectors.groupingBy(x->x, LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(x->x.getValue() == 1).map(Map.Entry::getKey).findFirst().get());

        int arr1[] = {2,3,10,40,20,24,30,34,50,54,44,40};

        //System.out.println(Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(x->x/10*10,LinkedHashMap::new,Collectors.toList()));

       Map<Integer,List<Integer>> result= Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(x->x/10*10,TreeMap::new,Collectors.toList()));

        System.out.println(result);

        String n[]= {"ewe","jji","abc","kwk","aha","dbd"};

        LinkedHashMap<String, List<String>> collect = Arrays.stream(n).collect(Collectors.groupingBy(x -> x.substring(1, 2), LinkedHashMap::new, Collectors.toList()));

        System.out.println(collect);


        int a2[] = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(IntStream.range(0,a2.length).filter(x->x % 2 == 0).map(a->a2[a]).reduce(1,(a,c)->a*c));

        System.out.println(IntStream.range(0,a2.length/2).map(a->a2[a]*a2[a2.length-a-1]).boxed().collect(Collectors.toList()));


        String a[] = {""};
        int c[] = {5,0,1,8,0,2,0};

        System.out.println(Arrays.stream(c).boxed().collect(Collectors.partitioningBy(x->x!=0)).values().stream().flatMap(List::stream).toList());

        System.out.println(Stream.iterate(1,x->x+1).limit(10).mapToInt(Integer::valueOf).sum());
    }

}





 
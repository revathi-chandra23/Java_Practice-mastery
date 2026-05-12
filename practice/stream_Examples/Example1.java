public class Example1 {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};
   
        System.out.println("Names starting with 'A':");
        java.util.Arrays.stream(names)
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
    }

}

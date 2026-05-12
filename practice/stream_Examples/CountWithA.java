public class CountWithA {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};
    
        long count = java.util.Arrays.stream(names)
                .filter(name -> name.startsWith("A"))
                .count();
    
        System.out.println("Number of names starting with 'A': " + count);
    }
    
}

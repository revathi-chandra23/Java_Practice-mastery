
public class FindAnyMethod {
    public static void main(String[] args) {
        System.out.println(java.util.stream.Stream.of(1,2,3,4,5).filter(e->e%2==0).findAny().orElse(-1));
        java.util.List<Integer> nums = java.util.Arrays.asList(1,2,3,4,5);
      System.out.println(  nums.stream()
                               .filter(n -> n > 3)
                               .findAny().orElse(-1));
    }
    
}

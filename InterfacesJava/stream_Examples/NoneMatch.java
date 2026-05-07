public class NoneMatch {
    public static void main(String[] args) {
        System.out.println(java.util.stream.Stream.of(1,2,3,4,5).noneMatch(e->e%2==0));
        java.util.List<Integer> nums = java.util.Arrays.asList(1,2,3,4,5);
      System.out.println(  nums.stream()
                               .filter(n -> n > 3)
                               .noneMatch(n->n%2==0));
    }
}

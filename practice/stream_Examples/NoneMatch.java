public class NoneMatch {
    public static void main(String[] args) {
        System.out.println(java.util.stream.Stream.of(1,2,3,4,5).noneMatch(e->e%2==0));
        java.util.List<Integer> nums = java.util.Arrays.asList(1,2,3,4,5);
      System.out.println(  nums.stream()
                               .filter(n -> n > 3)

                               .noneMatch(n -> n % 2 == 0));
                            


        List<List<String>> names = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("C", "D")
        );

        List<String> result = names.stream()
                                   .flatMap(List::stream)
                                   .collect(Collectors.toList());

        System.out.println(result);
    }
}
                            
                            

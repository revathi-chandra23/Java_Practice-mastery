

import java.util.concurrent.ConcurrentHashMap;

public class Example5 {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> h = new ConcurrentHashMap<>();
        h.put(1,"A");
        h.put(2,"b");
        h.put(3,"C");
        h.put(4,"D");
        h.put(5,"E");
        System.out.println(h.size());
        System.out.println(h);
        h.entrySet().forEach(entry -> System.out.println("key:" + entry.getKey()
                + ", value :" + entry.getValue())
        );
    }
}

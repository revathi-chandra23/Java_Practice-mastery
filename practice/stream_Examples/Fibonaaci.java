

import java.util.stream.Stream;

public class Fibonaaci {
    public static void main(String[] args) {
        System.out.println(Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]})
        .limit(20).map(t->t[0]).toList());
    }
}

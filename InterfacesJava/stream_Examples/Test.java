package org.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> ls= Arrays.asList("book","431","ring","3543","laptop","4234");
Map<String,Integer> map=ls.stream().collect(Collectors.toMap(s->s,s->s.length()));
        System.out.println(map.entrySet().stream().map(e->e.getKey()+"-"+e.getValue()).toList());
    }
}


package com.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubLists {
    public static void main(String[] args) {   
        List<Integer> list = Arrays.asList(1, 2, 3);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                res.add(new ArrayList<>(list.subList(i, j + 1)));
            }
        }
        System.out.println(res);
    }
}

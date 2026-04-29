package com.practice.practice_java;

import java.util.HashMap;

public class HashMapDuplicate {
    public static void main(String[] args) {

        String str = "madam";

        HashMap<Character, Integer> map = new HashMap<>();
        boolean hasDuplicate = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

        
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) > 1) {
                hasDuplicate = true;
            }
        }

        if (hasDuplicate) {
            System.out.println("Duplicate characters are present");
        } else {
            System.out.println("No duplicate characters");
        }
    }
}
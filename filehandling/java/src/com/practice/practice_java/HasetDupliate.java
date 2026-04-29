package com.practice.practice_java;
import java.util.HashSet;

public class HasetDupliate {
    public static void main(String[] args) {
      String str="madam";

HashSet<String> set=new HashSet<>();

      for(int i=0;i< str.length();i++){
          set.add(String.valueOf(str.charAt(i)));
        System.out.println(set);
    }
}

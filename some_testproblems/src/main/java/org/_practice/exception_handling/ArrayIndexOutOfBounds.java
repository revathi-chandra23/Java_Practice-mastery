package org._practice.exception_handling;

public class ArrayIndexOutOfBounds {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        try{
            System.out.println(a[6]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception: " + e);
        }
    }
}

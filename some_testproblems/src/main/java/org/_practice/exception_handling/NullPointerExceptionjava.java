package org._practice.exception_handling;

public class NullPointerExceptionjava {

    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println(str.length());
        } catch (java.lang.NullPointerException e) {
            System.out.println("NullPointerException: " + e);
        }
    }
}

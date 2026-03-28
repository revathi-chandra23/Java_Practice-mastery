package org._practice.exception_handling;

public class UseFinallly {
    public static void main(String[] args) {
        int a=10;
        int b=0;
        try
        {
            int c=a/b;
            System.out.println("Result: "+c);
        } catch (Exception e) {
            System.out.println("Arithmetic exception");
        }
        finally {
            System.out.println("Finally block is always executed");
        }
    }
}

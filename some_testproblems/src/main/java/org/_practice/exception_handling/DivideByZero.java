package org._practice.exception_handling;
// Divide by Zero Exception
//Write a Java program that takes two numbers as input and performs division.
//Handle the ArithmeticException if the denominator is zero and display an
//appropriate message.
public class DivideByZero
{
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            int c = a / b;
            System.out.println("Result: " + c);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e);
        }
    }
}

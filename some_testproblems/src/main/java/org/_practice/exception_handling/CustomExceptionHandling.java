package org._practice.exception_handling;

import java.util.Scanner;

public class CustomExceptionHandling
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the age: ");
        int a = sc.nextInt();
        try {
            if (a < 18) {
                throw new invalidAgeException("Invalid Age");
            } else {
                System.out.println("Valid Age");
            }
        } catch (invalidAgeException e) {
            System.out.println("Exception: " + e);

        }
    }
}

        class invalidAgeException extends Exception {
            public invalidAgeException(String s) {
                super(s);
            }
        }


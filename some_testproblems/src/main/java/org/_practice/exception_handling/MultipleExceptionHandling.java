package org._practice.exception_handling;

import java.util.Scanner;

public class MultipleExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the a: ");
        int a = sc.nextInt();
        System.out.println("enter the b: ");
        int b = sc.nextInt();
        System.out.println("enter the d: ");
        String d = sc.next();
        int[] arr = {1, 2, 3, 4, 5};
//        try{
//
//            int c=a/b;
//            System.out.println("Result: "+c);
//            int e=Integer.parseInt(d);
//            System.out.println("Value of e: "+e);
//            System.out.println(arr[9]);
//
//        }catch (ArithmeticException e) {
//            System.out.println("Arithmetic Exception: " + e);
//        }
//       catch(NumberFormatException e){
//            System.out.println("Number Format Exception: "+e);
//        }
//        catch (ArrayIndexOutOfBoundsException e)
//        {
//            System.out.println("ArrayIndexOutOfBounds Exception: " + e);
//        }
//        catch (Exception e)
//        {
//            System.out.println("Exception: " + e);
//        }

        String[] testCases = {"Arithmetic", "NumberFormat", "ArrayIndex"};

        for (String testCase : testCases) {
            try {
                switch (testCase) {
                    case "Arithmetic":
                        int c = a / b;
                        System.out.println("Result of a/b: " + c);
                        break;
                    case "NumberFormat":
                        int e = Integer.parseInt(d);
                        System.out.println("Converted integer value: " + e);
                        break;
                    case "ArrayIndex":
                        System.out.println("Accessing array element: " + arr[9]);
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBounds Exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("General Exception: " + e.getMessage());
            }
        }
    }
}

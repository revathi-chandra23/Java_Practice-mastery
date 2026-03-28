package org._practice.exception_handling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilenOtfound {
    public static void main(String[] args) {

    String line;
        try
    {
        BufferedReader br=new BufferedReader(new FileReader("src/main/java/org/atyeti/exception_handling/revathi.txt"));
        while((line=br.readLine())!=null)
        {
            System.out.println(line);
        }

    }catch (FileNotFoundException e)
    {
        System.out.println("IOException: " + e);
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

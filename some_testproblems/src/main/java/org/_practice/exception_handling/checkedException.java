package org._practice.exception_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class checkedException
{
    public static void main(String[] args) {
        String line;
        try
        {
            BufferedReader br=new BufferedReader(new FileReader("src/main/java/org/atyeti/exception_handling/revathi.txt"));
            while((line=br.readLine())!=null)
            {
                System.out.println(line);
            }

        }catch (IOException e)
        {
            System.out.println("IOException: " + e);
        }
    }
}

package fileHandling;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadTheFile {
    public static void main(String[] args) {
        try
        {
            FileReader read =new FileReader("filehandling\\java\\src\\fileHandling\\reader.txt");
            Scanner sc=new Scanner(read);  
            while(sc.hasNextLine())
            {
                String s=sc.nextLine();
                System.out.println(s);
            }
            System.out.println("file succesfully read");
            sc.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

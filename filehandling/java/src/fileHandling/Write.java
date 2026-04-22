package fileHandling;
import java.io.FileWriter;
import java.io.IOException;

public class
Write{
    public static void main(String[] args) {
        try
        {
            FileWriter writ=new FileWriter("run.txt");
            writ.write("hi , im revathi chandra");
            writ.close();
            System.out.println("successfully written");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


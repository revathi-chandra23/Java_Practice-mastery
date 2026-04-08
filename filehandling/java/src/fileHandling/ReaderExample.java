package fileHandling;



import java.io.FileReader;
import java.io.IOException;


public class ReaderExample {

    public static void main(String[] args) throws IOException {



        FileReader fileReader = new FileReader("filehandling\\java\\src\\fileHandling\\reader.txt");

        int character;

        while ((character = fileReader.read()) != -1) {

            System.out.print((char) character); // Print each character

        }

        fileReader.close();

    }

}
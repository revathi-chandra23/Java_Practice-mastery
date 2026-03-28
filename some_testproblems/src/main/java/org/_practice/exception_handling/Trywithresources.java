package org._practice.exception_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Trywithresources {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/RevathiTannidi/IdeaProjects/java_learning/src/Filehandling/output.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            // Print values
            for (String value : values) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
        br.close();
    }
}
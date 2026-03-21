package org.example;

import java.io.File;

import org.example.jsontopojo.PArent;
import org.example.service.Rename;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\jsonfilerenamedata\\src\\main\\resources\\data.json");
        PArent parent = mapper.readValue(file, PArent.class);

        Rename.renameAllNames(parent);
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, parent);

        System.out.println("File updated successfully.");
    }
}

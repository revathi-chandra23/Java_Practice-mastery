package org.example;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;

public class MainApp {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\jsonfile\\src\\main\\java\\org\\example\\jsonFile\\data.json");
        String keyToRename = "name";
        String newValue = "revathi chandra";

        JsonFileHandler fileHandler = new JsonFileHandler();

        try {
            JsonNode json = fileHandler.readJson(file);
            JsonNode updatedJson = JSonValueRenamer.renameNameValues(json, newValue);
            fileHandler.writeJson(file, updatedJson);

            System.out.println("All '" + keyToRename + "' values updated to '" + newValue + "'.");
        } catch (Exception e) {
            System.err.println(" Error: " + e.getMessage());
        }
    }
}

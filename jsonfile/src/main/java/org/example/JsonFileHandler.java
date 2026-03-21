package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;



public class JsonFileHandler {
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonNode readJson(File file) throws IOException {
        return mapper.readTree(file);
    }

    public void writeJson(File file, JsonNode node) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, node);
    }
}

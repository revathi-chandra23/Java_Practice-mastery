package org.atyeti.multiThreaded_json_logs.util;


import org.atyeti.multiThreaded_json_logs.model.LogEntry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static LogEntry parse(JsonNode node) {
        try {
            return mapper.convertValue(node, LogEntry.class);
        } catch (Exception e) {
            return null;
        }
    }
}
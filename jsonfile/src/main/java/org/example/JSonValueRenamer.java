package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.Iterator;
import java.util.Map;

public class JSonValueRenamer {

    public static JsonNode renameNameValues(JsonNode node, String newValue) {
        if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;
            Iterator<Map.Entry<String, JsonNode>> fields = objectNode.fields();

            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String key = entry.getKey();
                JsonNode value = entry.getValue();

                if (key.equals("name") && value.isTextual()) {
                    objectNode.put(key, newValue);
                } else {
                    renameNameValues(value, newValue);
                }
            }
        } else if (node.isArray()) {
            for (JsonNode item : node) {
                renameNameValues(item, newValue);
            }
        }

        return node;
    }
}

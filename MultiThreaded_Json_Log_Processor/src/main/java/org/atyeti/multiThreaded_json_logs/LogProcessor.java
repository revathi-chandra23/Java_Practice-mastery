package org.atyeti.multiThreaded_json_logs;

import org.atyeti.multiThreaded_json_logs.model.LogEntry;
import org.atyeti.multiThreaded_json_logs.service.LogService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.concurrent.*;

public class LogProcessor {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Documents\\Revathi_Practice\\MultiThreaded_Json_Log_Processor\\src\\main\\resources\\logs.json";

        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        LogService service = new LogService();
        ObjectMapper mapper = new ObjectMapper();

        long start = System.currentTimeMillis();

        try {

            // ✅ Read full JSON array
            JsonNode root = mapper.readTree(new File(filePath));

            // ✅ Iterate each JSON object
            for (JsonNode node : root) {

                executor.submit(() -> {
                    try {
                        // Convert JsonNode → LogEntry object
                        LogEntry log = mapper.convertValue(node, LogEntry.class);

                        // Process log
                        service.process(log);

                    } catch (Exception e) {
                        System.out.println("Failed to process node: " + node);
                    }
                });
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        service.printResults();

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
    }
}
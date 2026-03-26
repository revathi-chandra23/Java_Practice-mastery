package org.atyeti.multiThreaded_json_logs;

import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LogProcessor {

    private static ConcurrentHashMap<String, AtomicInteger> errorCount = new ConcurrentHashMap<>();
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        String filePath = "src/main/resources/logs.json";

        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        long startTime = System.currentTimeMillis();

        try {

            JsonNode root = mapper.readTree(new File(filePath));

            for (JsonNode node : root) {

                executor.submit(() -> processLog(node));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();


        System.out.println("ERROR count per service:");
        errorCount.forEach((service, count) ->
                System.out.println(service + " -> " + count.get())
        );

        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    private static void processLog(JsonNode node) {
        try {
            String level = node.get("level").asText();

            if ("ERROR".equals(level)) {

                String service = node.get("service").asText();

                errorCount
                        .computeIfAbsent(service, k -> new AtomicInteger(0))
                        .incrementAndGet();
            }

        } catch (Exception e) {
         e.printStackTrace();
        }
    }
}
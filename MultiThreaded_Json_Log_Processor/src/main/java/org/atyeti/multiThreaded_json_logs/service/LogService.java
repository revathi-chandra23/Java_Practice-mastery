package org.atyeti.multiThreaded_json_logs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.atyeti.multiThreaded_json_logs.model.LogEntry;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LogService {

    // Separate maps for each level
    private ConcurrentHashMap<String, AtomicInteger> errorCount = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, AtomicInteger> warnCount = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, AtomicInteger> infoCount = new ConcurrentHashMap<>();


    public void process(LogEntry log) {

        if (log == null) return;

        String service = log.getService();
        String level = log.getLevel().toUpperCase();

        switch (level) {
            case "ERROR":
                increment(errorCount, service);
                break;
            case "WARN":
                increment(warnCount, service);
                break;
            case "INFO":
                increment(infoCount, service);
                break;
            default:

        }
    }

    private void increment(ConcurrentHashMap<String, AtomicInteger> map, String service) {
        map.computeIfAbsent(service, k -> new AtomicInteger(0))
                .incrementAndGet();
    }


    public void printResults() {



        System.out.println("\nERROR count per service:");
        errorCount.forEach((service, count) ->
                System.out.println(service + " -> " + count.get())
        );

        System.out.println("\nWARN count per service:");
        warnCount.forEach((service, count) ->
                System.out.println(service + " -> " + count.get())
        );

        System.out.println("\nINFO count per service:");
        infoCount.forEach((service, count) ->
                System.out.println(service + " -> " + count.get())
        );
    }


    public void writeToJsonFile(String outputPath) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Map<String, Map<String, Integer>> result = new HashMap<>();


            errorCount.forEach((service, count) -> {
                result.computeIfAbsent(service, k -> new HashMap<>())
                        .put("ERROR", count.get());
            });

            warnCount.forEach((service, count) -> {
                result.computeIfAbsent(service, k -> new HashMap<>())
                        .put("WARN", count.get());
            });


            infoCount.forEach((service, count) -> {
                result.computeIfAbsent(service, k -> new HashMap<>())
                        .put("INFO", count.get());
            });


            Map<String, Object> finalOutput = new HashMap<>();
            finalOutput.put("processedAt", java.time.LocalDateTime.now().toString());
            finalOutput.put("services", result);


            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(outputPath), finalOutput);

            System.out.println("\n Results written to: " + outputPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package org.atyeti.multiThreaded_json_logs.service;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.atyeti.multiThreaded_json_logs.model.LogEntry;

public class LogService {

    private ConcurrentHashMap<String, AtomicInteger> errorCount = new ConcurrentHashMap<>();
     private ConcurrentHashMap<String, AtomicInteger> infoCount = new ConcurrentHashMap<>();
      private ConcurrentHashMap<String, AtomicInteger> warnCount = new ConcurrentHashMap<>();

    public void process(LogEntry log) {

        if (log == null) return;

        if ("ERROR".equals(log.getLevel())) {

            errorCount
                    .computeIfAbsent(log.getService(), k -> new AtomicInteger(0))
                    .incrementAndGet();
        }
    
    if ("WARN".equals(log.getLevel())) {

            warnCount
                    .computeIfAbsent(log.getService(), k -> new AtomicInteger(0))
                    .incrementAndGet();
        }
    
        if ("INFO".equals(log.getLevel())) {

            infoCount
                    .computeIfAbsent(log.getService(), k -> new AtomicInteger(0))
                    .incrementAndGet();
        }
    }
    public void printResults() {
        System.out.println("ERROR count per service:");
        errorCount.forEach((service, count) ->
                System.out.println(service + " -> " + count.get())
        );
         System.out.println("\n WARN count per service:");
        warnCount.forEach((service, count) ->
                System.out.println(service + " -> " + count.get())
        );
         System.out.println("\n INFO count per service:");
        infoCount.forEach((service, count) ->
                System.out.println(service + " -> " + count.get())
        );
    }
}
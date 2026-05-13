package logAnalyzer.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LogAnalyzer {

    public static void main(String[] args) {

        File logDir = new File("logs");

        List<Thread> threads = new ArrayList<>();

        File[] files = logDir.listFiles((dir, name) -> name.endsWith(".log"));

        if (files == null) {

            System.out.println("No log files found");

            return;
        }

        for (File file : files) {
            Thread thread = new LogFileThreadReader(file);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        LogReport report = new LogReport(
                LogProcessorService.getErrorCount(),
                LogProcessorService.getWarningCount(),
                LogProcessorService.getInfoCount());

        LogReportDAO dao = new LogReportDAO();

        dao.saveReport(report);

        System.out.println("\n===== FINAL REPORT =====");
        System.out.println("ERROR COUNT : " + report.getErrorCount());
        System.out.println("WARNING COUNT : " + report.getWarningCount());
        System.out.println("INFO COUNT : " + report.getInfoCount());
    }
}
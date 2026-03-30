package org.practice.java.salesAnalzer;

import java.util.List;

import org.practice.java.salesAnalzer.exception.DataAnalysisException;
import org.practice.java.salesAnalzer.model.SaleRecord;
import org.practice.java.salesAnalzer.service.ProductAnalyzer;
import org.practice.java.salesAnalzer.service.RegionAnalyzer;
import org.practice.java.salesAnalzer.service.RevenueCalculator;
import org.practice.java.salesAnalzer.util.CSVReaderUtil;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Documents\\Revathi_Practice\\sales_Report_generator\\pom.xml";

        try {
            List<SaleRecord> salesRecords = CSVReaderUtil.readSalesFromCSV(filePath);
//            salesRecords.forEach(System.out::println); // Debug: Print all records
            if (salesRecords.isEmpty()) {
                System.out.println("No data ");
                return;
            }

            new RevenueCalculator(salesRecords).start();
            new ProductAnalyzer(salesRecords).start();
            new RegionAnalyzer(salesRecords).start();

        } catch (DataAnalysisException e) {
            System.err.println("Application Error: " + e.getMessage());
            e.printStackTrace();
        }
    }


}

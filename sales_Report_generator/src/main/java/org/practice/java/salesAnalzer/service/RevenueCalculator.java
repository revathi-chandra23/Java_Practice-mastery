package org.practice.java.salesAnalzer.service;

import java.util.List;

import org.practice.java.salesAnalzer.exception.DataAnalysisException;
import org.practice.java.salesAnalzer.model.SaleRecord;
import org.practice.java.salesAnalzer.util.CSVWriterUtil;

public class RevenueCalculator extends  Thread {

    private final List<SaleRecord> records;

    public RevenueCalculator(List<SaleRecord> records) {
        this.records = records;
    }

    @Override
    public void run() {
        try {
            double totalRevenue = records.stream()
                    .mapToDouble(SaleRecord::getTotalRevenue)
                    .sum();

            System.out.printf("Total Revenue: $%.2f%n", totalRevenue);
            CSVWriterUtil.revenueToCSV(totalRevenue, "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Documents\\Revathi_Practice\\sales_Report_generator\\src\\main\\reports\\revenue.csv");

        } catch (DataAnalysisException e) {
            System.err.println("Revenue calculation failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

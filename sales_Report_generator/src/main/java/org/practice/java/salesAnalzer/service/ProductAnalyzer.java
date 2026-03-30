package org.practice.java.salesAnalzer.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.practice.java.salesAnalzer.exception.DataAnalysisException;
import org.practice.java.salesAnalzer.model.SaleRecord;
import org.practice.java.salesAnalzer.util.CSVWriterUtil;

public class ProductAnalyzer extends  Thread{

    private final List<SaleRecord> records;

    public ProductAnalyzer(List<SaleRecord> records) {
        this.records = records;
    }

    @Override
    public void run() {
        try {
            Map<String, Integer> productUnits = records.stream() 
                    .collect(Collectors.groupingBy(SaleRecord::getProductId,
                            Collectors.summingInt(SaleRecord::getUnitsSold)));  // Group by product and sum units sold

            List<Map.Entry<String, Integer>> sortedProducts = productUnits.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .toList(); // Sort products by units sold in descending order

            System.out.println("Top Selling Products:");
            sortedProducts.forEach(e ->
                    System.out.println(e.getKey() + ": " + e.getValue() + " units"));

            CSVWriterUtil.topProductsToCSV(sortedProducts, "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Documents\\Revathi_Practice\\sales_Report_generator\\src\\main\\reports\\top_products.csv");

        } catch (DataAnalysisException e) {
            System.err.println("product analysis failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

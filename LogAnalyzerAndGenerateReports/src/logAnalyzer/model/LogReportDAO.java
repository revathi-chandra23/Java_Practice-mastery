package org.atyeti.loganalyzer.database;

import org.atyeti.loganalyzer.model.LogReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class LogReportDAO {

    public void createTable() {

        String query = "CREATE TABLE IF NOT EXISTS logs (" + "id INT PRIMARY KEY AUTO_INCREMENT, " + "error_count INT, "
                        + "warning_count INT, " + "info_count INT" + ")";

        try( Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement())
        {
            statement.executeUpdate(query);
            System.out.println("Table created successfully");
        }

        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveReport(LogReport report) {
        String query = "INSERT INTO logs " + "(error_count, warning_count, info_count) " + "VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, report.getErrorCount());
            ps.setInt(2, report.getWarningCount());
            ps.setInt(3, report.getInfoCount());
            ps.executeUpdate();
            System.out.println("Data inserted successfully");
        }

        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
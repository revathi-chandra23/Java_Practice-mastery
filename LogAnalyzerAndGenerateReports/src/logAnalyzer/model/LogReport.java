package org.atyeti.loganalyzer.model;

public class LogReport {

    private int errorCount;

    private int warningCount;

    private int infoCount;

    public LogReport(int errorCount, int warningCount, int infoCount) {
        this.errorCount = errorCount;
        this.warningCount = warningCount;
        this.infoCount = infoCount;
    }

    public int getErrorCount() {

        return errorCount;
    }

    public int getWarningCount() {

        return warningCount;
    }

    public int getInfoCount() {

        return infoCount;
    }
}
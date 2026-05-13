package org.atyeti.loganalyzer.model;

public class Log {

    private String message;

    public Log(String message) {

        this.message = message;
    }

    public String getMessage() {

        return message;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Log log = (Log) obj;

        return message.equals(log.message);
    }

    @Override
    public int hashCode() {

        return message.hashCode();
    }
}
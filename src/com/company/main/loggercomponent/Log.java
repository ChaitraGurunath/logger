package com.company.main.loggercomponent;

public class Log {
    private SeverityLevel severityLevel;
    private String message;
    private long time;


    public Log(SeverityLevel severityLevel, String message, long time) {
        this.severityLevel = severityLevel;
        this.message = message;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(SeverityLevel severityLevel) {
        this.severityLevel = severityLevel;
    }
}

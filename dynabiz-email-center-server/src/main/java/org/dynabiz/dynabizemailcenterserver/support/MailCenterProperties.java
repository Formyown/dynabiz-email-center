package org.dynabiz.dynabizemailcenterserver.support;

import org.springframework.boot.context.properties.ConfigurationProperties;


public class MailCenterProperties {
    public enum LogLevel{
        TITLE("title"),
        BODY("body"),
        NONE("none");

        private String value;
        LogLevel(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private String from;
    private LogLevel logLevel;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}

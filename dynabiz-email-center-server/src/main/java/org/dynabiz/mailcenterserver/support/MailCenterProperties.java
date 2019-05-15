package org.dynabiz.mailcenterserver.support;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="mail-center.server")
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

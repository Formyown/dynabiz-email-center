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

    public String address;
    public LogLevel logLevel;
}

package org.dynabiz.dynabizemailcenterserver.support;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service.properties")
public class MailCenterProperties {
    public String address;
    public String
}

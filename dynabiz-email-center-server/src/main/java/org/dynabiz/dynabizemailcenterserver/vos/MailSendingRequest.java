package org.dynabiz.dynabizemailcenterserver.vos;

import java.util.Map;

public class MailSendingRequest {
    private String templateName;
    private Map<String, Object> args;
    private String toAddress;

    public MailSendingRequest() {
    }

    public MailSendingRequest(String templateName, Map<String, Object> args, String toAddress) {
        this.templateName = templateName;
        this.args = args;
        this.toAddress = toAddress;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Map<String, Object> getArgs() {
        return args;
    }

    public void setArgs(Map<String, Object> args) {
        this.args = args;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
}

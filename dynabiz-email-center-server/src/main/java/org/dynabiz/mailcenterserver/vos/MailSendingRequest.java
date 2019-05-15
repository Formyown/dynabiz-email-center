package org.dynabiz.mailcenterserver.vos;

import java.util.Map;

public class MailSendingRequest {
    private String templateName;
    private Map args;
    private String toAddress;

    public MailSendingRequest() {
    }

    public MailSendingRequest(String templateName, Map args, String toAddress) {
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

    public Map getArgs() {
        return args;
    }

    public void setArgs(Map args) {
        this.args = args;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
}

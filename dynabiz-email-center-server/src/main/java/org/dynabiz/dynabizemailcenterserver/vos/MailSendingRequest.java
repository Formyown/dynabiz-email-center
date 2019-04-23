package org.dynabiz.dynabizemailcenterserver.vos;

public class MailSendingRequest {
    private String subject;
    private String body;
    private String toAddress;
    private String fromAddress;

    public MailSendingRequest() {
    }

    public MailSendingRequest(String subject, String body, String toAddress, String fromAddress) {
        this.subject = subject;
        this.body = body;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }
}

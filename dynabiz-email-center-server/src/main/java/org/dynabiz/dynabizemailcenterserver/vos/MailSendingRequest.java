package org.dynabiz.dynabizemailcenterserver.vos;

public class MailSendingRequest {
    private String body;
    private String title;
    private String toAddress;
    private String fromAddress;

    public MailSendingRequest() {
    }

    public MailSendingRequest(String body, String title, String toAddress, String fromAddress) {
        this.body = body;
        this.title = title;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

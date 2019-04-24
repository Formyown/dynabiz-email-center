package org.dynabiz.dynabizemailcenterserver.vos;

public class MailSendingData  extends  MailData{
    private String toAddress;
    private String fromAddress;

    public static MailSendingData fromMailData(MailData data, String from, String to){
        return new MailSendingData(data.getSubject(), data.getBody(), from, to);
    }

    public MailSendingData() {
    }

    public MailSendingData(String subject, String body, String toAddress, String fromAddress) {
        super(subject, body);
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
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
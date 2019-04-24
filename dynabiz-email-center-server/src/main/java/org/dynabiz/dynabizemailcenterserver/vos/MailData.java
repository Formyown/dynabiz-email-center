package org.dynabiz.dynabizemailcenterserver.vos;

public class MailData {

    private String subject;
    private String body;


    public MailData() {
    }

    public MailData(String subject, String body) {
        this.subject = subject;
        this.body = body;

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


}
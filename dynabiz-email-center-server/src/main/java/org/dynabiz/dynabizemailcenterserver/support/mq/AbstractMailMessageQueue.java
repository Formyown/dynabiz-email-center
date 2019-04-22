package org.dynabiz.dynabizemailcenterserver.support.mq;


import org.dynabiz.dynabizemailcenterserver.support.mail.MailSendingHandler;
import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;


public abstract class AbstractMailMessageQueue {
    private MailSendingHandler handler;

    AbstractMailMessageQueue(MailSendingHandler handler){
        this.handler = handler;
    }

    protected abstract void handleRequest(MailSendingHandler handler);

    public abstract void push(MailSendingRequest request);
}

package org.dynabiz.dynabizemailcenterserver.support.mq;


import org.dynabiz.dynabizemailcenterserver.service.MailSendingRequestHandler;
import org.dynabiz.dynabizemailcenterserver.support.mail.MailSender;
import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;


public abstract class AbstractMailMessageQueue {
    private MailSendingRequestHandler handler;

    AbstractMailMessageQueue(MailSendingRequestHandler handler){
        this.handler = handler;
    }

    protected void handleRequest(MailSendingRequest request){
        this.handler.send(request);
    }

    public abstract void push(MailSendingRequest request);
}

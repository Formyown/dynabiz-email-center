package org.dynabiz.mailcenterserver.support.mq;


import org.dynabiz.mailcenterserver.service.SendingRequestHandler;
import org.dynabiz.mailcenterserver.vos.MailSendingRequest;


public abstract class AbstractMailMessageQueue {
    private SendingRequestHandler handler;

    AbstractMailMessageQueue(SendingRequestHandler handler){
        this.handler = handler;
    }

    protected void handleRequest(MailSendingRequest request){
        this.handler.send(request);
    }

    public abstract void push(MailSendingRequest request);
}

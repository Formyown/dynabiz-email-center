package org.dynabiz.dynabizemailcenterserver.support.mq;

import org.dynabiz.dynabizemailcenterserver.support.mail.MailSendingHandler;
import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;
import org.dynabiz.dynabizemailcenterserver.vos.dto.SendEmailTransfer;

public class RabbitMessageQueueSupport extends AbstractMailMessageQueue {

    public RabbitMessageQueueSupport(MailSendingHandler handler) {
        super(handler);
    }

    @Override
    protected void handleRequest(MailSendingHandler handler) {

    }

    @Override
    public void push(MailSendingRequest request) {

    }

}

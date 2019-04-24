package org.dynabiz.dynabizemailcenterserver.support.mq;

import org.dynabiz.dynabizemailcenterserver.service.MailSendingRequestHandler;
import org.dynabiz.dynabizemailcenterserver.support.mail.MailSender;
import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;

public class RabbitMessageQueueSupport extends AbstractMailMessageQueue {

    public RabbitMessageQueueSupport(MailSendingRequestHandler handler) {
        super(handler);
    }



    @Override
    public void push(MailSendingRequest request) {

    }

}

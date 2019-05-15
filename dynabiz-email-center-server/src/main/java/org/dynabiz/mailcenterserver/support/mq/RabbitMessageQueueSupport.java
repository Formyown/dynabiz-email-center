package org.dynabiz.mailcenterserver.support.mq;

import org.dynabiz.mailcenterserver.service.SendingRequestHandler;
import org.dynabiz.mailcenterserver.vos.MailSendingRequest;

public class RabbitMessageQueueSupport extends AbstractMailMessageQueue {

    public RabbitMessageQueueSupport(SendingRequestHandler handler) {
        super(handler);
    }



    @Override
    public void push(MailSendingRequest request) {

    }

}

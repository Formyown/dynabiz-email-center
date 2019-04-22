package org.dynabiz.dynabizemailcenterserver.support.mq;

import org.dynabiz.dynabizemailcenterserver.support.mail.MailSendHandler;
import org.dynabiz.dynabizemailcenterserver.vos.dto.SendEmailTransfer;

public class RabbitMessageQueueSupport implements MailMessageQueue {
    @Override
    public void push(SendEmailTransfer sendEmail) {

    }

    @Override
    public void bindHandler(MailSendHandler handler) {

    }
}

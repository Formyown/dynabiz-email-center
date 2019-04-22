package org.dynabiz.dynabizemailcenterserver.support.mq;

import org.dynabiz.dynabizemailcenterserver.support.mail.MailSendHandler;
import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;
import org.dynabiz.dynabizemailcenterserver.vos.dto.SendEmailTransfer;

public class RedisMessageQueueSupport implements MailMessageQueue {
    @Override
    public void push(MailSendingRequest request) {

    }

    @Override
    public void bindHandler(MailSendHandler handler) {

    }
}

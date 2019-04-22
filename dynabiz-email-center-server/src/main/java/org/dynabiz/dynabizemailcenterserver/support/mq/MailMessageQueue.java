package org.dynabiz.dynabizemailcenterserver.support.mq;


import org.dynabiz.dynabizemailcenterserver.support.mail.MailSendHandler;
import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;


public interface MailMessageQueue {
    void push(MailSendingRequest request);
    void bindHandler(MailSendHandler handler);
}

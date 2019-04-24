package org.dynabiz.dynabizemailcenterserver.support.mail;

import org.dynabiz.dynabizemailcenterserver.vos.MailSendingData;


public interface MailSender {
    void send(MailSendingData mail);
}

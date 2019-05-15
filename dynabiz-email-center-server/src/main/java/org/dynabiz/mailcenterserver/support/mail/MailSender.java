package org.dynabiz.mailcenterserver.support.mail;

import org.dynabiz.mailcenterserver.vos.MailSendingData;


public interface MailSender {
    void send(MailSendingData mail);
}

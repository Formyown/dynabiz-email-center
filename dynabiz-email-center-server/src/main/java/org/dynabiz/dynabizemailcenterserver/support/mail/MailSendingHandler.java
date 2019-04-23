package org.dynabiz.dynabizemailcenterserver.support.mail;

import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;


public interface MailSendingHandler {
    void send(MailSendingRequest mail);
}

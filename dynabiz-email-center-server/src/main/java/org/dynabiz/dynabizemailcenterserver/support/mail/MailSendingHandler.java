package org.dynabiz.dynabizemailcenterserver.support.mail;

import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;
import org.dynabiz.dynabizemailcenterserver.vos.entity.MailEntity;

public interface MailSendingHandler {
    void send(MailSendingRequest mail);
}

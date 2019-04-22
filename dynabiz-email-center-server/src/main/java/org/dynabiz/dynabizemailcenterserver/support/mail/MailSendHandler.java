package org.dynabiz.dynabizemailcenterserver.support.mail;

import org.dynabiz.dynabizemailcenterserver.vos.entity.MailEntity;

public interface MailSendHandler {
    void send(MailEntity mail);
}

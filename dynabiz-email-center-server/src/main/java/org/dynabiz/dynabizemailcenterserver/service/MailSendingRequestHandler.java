package org.dynabiz.dynabizemailcenterserver.service;

import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;

public interface MailSendingRequestHandler {
    void send(MailSendingRequest mail);
}

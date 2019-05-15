package org.dynabiz.mailcenterserver.service;

import org.dynabiz.mailcenterserver.vos.MailSendingRequest;

public interface SendingRequestHandler {
    void send(MailSendingRequest mail);
}

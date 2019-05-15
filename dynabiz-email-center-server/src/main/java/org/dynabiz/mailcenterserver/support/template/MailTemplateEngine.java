package org.dynabiz.mailcenterserver.support.template;

import org.dynabiz.mailcenterserver.vos.MailData;

import java.util.Map;

public interface MailTemplateEngine {
    MailData apply(String titleTemplate, String bodyTemplate, Map<String, Object> data);


}

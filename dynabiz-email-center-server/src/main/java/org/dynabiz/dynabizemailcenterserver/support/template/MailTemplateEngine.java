package org.dynabiz.dynabizemailcenterserver.support.template;

import org.dynabiz.dynabizemailcenterserver.vos.MailData;

import java.util.Map;

public interface MailTemplateEngine {
    MailData apply(String titleTemplate, String bodyTemplate, Map<String, Object> data);


}

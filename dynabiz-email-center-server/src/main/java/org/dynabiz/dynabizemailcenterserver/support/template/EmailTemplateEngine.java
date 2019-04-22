package org.dynabiz.dynabizemailcenterserver.support.template;

import org.dynabiz.dynabizemailcenterserver.vos.entity.MailEntity;

import java.util.Map;

public interface EmailTemplateEngine {
    MailEntity apply(String titleTemplate, Map<String, Object> titleArgs,
                     String bodyTemplate, Map<String, Object> bodyArgs);


}

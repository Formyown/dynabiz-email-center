package org.dynabiz.dynabizemailcenterserver.support.template;

import org.dynabiz.dynabizemailcenterserver.vos.entity.MailEntity;

import java.util.Map;

public class ThymeleafTemplateEngineSupport implements EmailTemplateEngine {


    public ThymeleafTemplateEngineSupport(){
    }

    @Override
    public MailEntity apply(String titleTemplate, Map<String, Object> titleArgs, String bodyTemplate, Map<String, Object> bodyArgs) {
        return null;
    }
}

package org.dynabiz.dynabizemailcenterserver.support.template;

import org.dynabiz.dynabizemailcenterserver.vos.MailData;

import java.util.Map;

public class ThymeleafTemplateEngineSupport implements MailTemplateEngine {


    public ThymeleafTemplateEngineSupport(){
    }


    @Override
    public MailData apply(String titleTemplate, String bodyTemplate, Map<String, Object> data) {
        return null;
    }
}

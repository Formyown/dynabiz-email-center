package org.dynabiz.mailcenterserver.support.template;

import org.dynabiz.mailcenterserver.vos.MailData;

import java.util.Map;

public class ThymeleafTemplateEngineSupport implements MailTemplateEngine {


    public ThymeleafTemplateEngineSupport(){
    }


    @Override
    public MailData apply(String titleTemplate, String bodyTemplate, Map<String, Object> data) {
        return null;
    }
}

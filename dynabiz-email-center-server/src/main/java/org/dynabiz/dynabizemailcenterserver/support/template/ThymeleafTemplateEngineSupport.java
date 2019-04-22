package org.dynabiz.dynabizemailcenterserver.support.template;

import org.dynabiz.dynabizemailcenterserver.support.template.EmailTemplateEngine;

import java.util.Map;

public class ThymeleafTemplateEngineSupport implements EmailTemplateEngine {


    public ThymeleafTemplateEngineSupport(){
    }

    @Override
    public EmailEntity apply(String titleTemplate, Map<String, Object> titleArgs, String bodyTemplate, Map<String, Object> bodyArgs) {
        return null;
    }
}

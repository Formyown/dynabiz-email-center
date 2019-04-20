package org.dynabiz.dynabizemailcenterserver.support.template;

import org.dynabiz.dynabizemailcenterserver.support.template.EmailTemplateEngine;

import java.util.Map;

public class ThymeleafTemplateEngineSupport implements EmailTemplateEngine {


    public ThymeleafTemplateEngineSupport(){
    }
    @Override
    public String apply(String template, Map<String, Object> args) {
        return null;
    }
}

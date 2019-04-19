package org.dynabiz.dynabizemailcenterserver.support;

import freemarker.template.Template;

import java.util.Map;

public class FreeMarkerTemplateEngineSupport implements EmailTemplateEngine {
    private Template template;

    public FreeMarkerTemplateEngineSupport(){
        template = new Template();
    }
    @Override
    public String apply(String template, Map<String, Object> args) {
        return null;
    }
}

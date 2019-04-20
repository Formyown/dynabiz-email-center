package org.dynabiz.dynabizemailcenterserver.support.template;

import freemarker.template.Template;

import java.util.Map;

public class FreeMarkerTemplateEngineSupport implements EmailTemplateEngine {


    public FreeMarkerTemplateEngineSupport(){

    }

    @Override
    public EmailEntity apply(String titleTemplate, Map<String, Object> titleArgs, String bodyTemplate, Map<String, Object> bodyArgs) {
        Template template = Template.getPlainTextTemplate("TITLE-TEMPLATE", titleTemplate, Configuration.);
        return null;
    }
}

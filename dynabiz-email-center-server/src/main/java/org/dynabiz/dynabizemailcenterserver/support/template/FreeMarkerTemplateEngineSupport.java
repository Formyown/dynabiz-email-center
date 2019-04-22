package org.dynabiz.dynabizemailcenterserver.support.template;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreeMarkerTemplateEngineSupport implements EmailTemplateEngine {
    private static final Logger logger = LoggerFactory.getLogger(FreeMarkerTemplateEngineSupport.class);

    public FreeMarkerTemplateEngineSupport(){

    }

    @Override
    public EmailEntity apply(String titleTemplate, Map<String, Object> titleArgs, String bodyTemplate, Map<String, Object> bodyArgs) {
        Configuration config = new Configuration(Configuration.VERSION_2_3_0);
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        stringLoader.putTemplate("BODY_TEMPLATE", bodyTemplate);
        stringLoader.putTemplate("TITLE_TEMPLATE", titleTemplate);
        config.setTemplateLoader(stringLoader);


        StringWriter bodyWriter = new StringWriter();
        StringWriter titleWriter = new StringWriter();
        try {
            Template templateInstance = config.getTemplate("BODY_TEMPLATE","utf-8");
            templateInstance.process(bodyArgs, bodyWriter);
            templateInstance = config.getTemplate("TITLE_TEMPLATE","utf-8");
            templateInstance.process(titleArgs, titleWriter);
        } catch (IOException | TemplateException e) {
            logger.error("Can not apply template", e);
        }

        return new EmailEntity(titleWriter.toString(), bodyWriter.toString());
    }
}

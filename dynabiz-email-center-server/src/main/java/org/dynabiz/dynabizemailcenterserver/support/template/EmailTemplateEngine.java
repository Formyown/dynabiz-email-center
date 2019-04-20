package org.dynabiz.dynabizemailcenterserver.support.template;

import java.util.Map;

public interface EmailTemplateEngine {
    EmailEntity apply(String titleTemplate, Map<String, Object> titleArgs,
                 String bodyTemplate, Map<String, Object> bodyArgs);

    class EmailEntity {
        public String title;
        public String body;
    }
}

package org.dynabiz.dynabizemailcenterserver.support;

import java.util.Map;

public interface EmailTemplateEngine {
    String apply(String template, Map<String, Object> args);
}

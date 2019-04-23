package org.dynabiz.dynabizemailcenterserver.vos.dto;


import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplateTestData;
import org.dynabiz.mapper.MappedConfig;

@MappedConfig(targetClass = MailTemplateTestData.class)
public class UploadTemplateTestDataTransfer{
    private String name;
    private String email;
    private String data;
    private String description;


}

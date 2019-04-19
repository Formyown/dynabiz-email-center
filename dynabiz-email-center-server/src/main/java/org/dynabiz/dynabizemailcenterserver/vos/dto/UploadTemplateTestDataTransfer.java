package org.dynabiz.dynabizemailcenterserver.vos.dto;


import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplateTestData;

@MappedConfig(targetClass = MailTemplateTestData.class)
public class UploadTemplateTestDataTransfer extends MappedData<UploadTemplateTestDataTransfer> {
    private String name;
    private String email;
    private String data;
    private String description;


}

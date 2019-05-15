package org.dynabiz.mailcenterserver.vos.dto;



public class UploadTemplateTransfer{
    private String name;
    private String titleTemplate;
    private String contentTemplate;
    private String description;

    public UploadTemplateTransfer() {
    }

    public UploadTemplateTransfer(String name, String titleTemplate, String contentTemplate, String description) {
        this.name = name;
        this.titleTemplate = titleTemplate;
        this.contentTemplate = contentTemplate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleTemplate() {
        return titleTemplate;
    }

    public void setTitleTemplate(String titleTemplate) {
        this.titleTemplate = titleTemplate;
    }

    public String getContentTemplate() {
        return contentTemplate;
    }

    public void setContentTemplate(String contentTemplate) {
        this.contentTemplate = contentTemplate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UploadTemplateTransfer{" +
                "name='" + name + '\'' +
                ", titleTemplate='" + titleTemplate + '\'' +
                ", contentTemplate='" + contentTemplate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

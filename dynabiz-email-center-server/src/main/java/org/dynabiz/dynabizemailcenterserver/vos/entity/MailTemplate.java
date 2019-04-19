package org.dynabiz.dynabizemailcenterserver.vos.entity;


import java.util.Date;
import java.util.Objects;

public class MailTemplate {
    private String id;
    private String name;
    private Date createAt;
    private Date modifyAt;
    private String titleTemplate;
    private String contentTemplate;
    private String description;

    public MailTemplate() {
    }

    public MailTemplate(String id, String name, Date createAt, Date modifyAt, String titleTemplate, String contentTemplate, String description) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.modifyAt = modifyAt;
        this.titleTemplate = titleTemplate;
        this.contentTemplate = contentTemplate;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
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
        return "MailTemplate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createAt=" + createAt +
                ", modifyAt=" + modifyAt +
                ", titleTemplate='" + titleTemplate + '\'' +
                ", contentTemplate='" + contentTemplate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MailTemplate)) return false;
        MailTemplate that = (MailTemplate) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(modifyAt, that.modifyAt) &&
                Objects.equals(titleTemplate, that.titleTemplate) &&
                Objects.equals(contentTemplate, that.contentTemplate) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createAt, modifyAt, titleTemplate, contentTemplate, description);
    }
}


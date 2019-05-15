package org.dynabiz.mailcenterserver.vos.entity;


import java.io.Serializable;
import java.util.Objects;

public class MailTemplateTestData implements Serializable {
    private String id;
    private String name;
    private String email;
    private String data;
    private String description;

    public MailTemplateTestData() {
    }

    public MailTemplateTestData(String id, String name, String email, String data, String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.data = data;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MailTemplateTestData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", data='" + data + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MailTemplateTestData)) return false;
        MailTemplateTestData that = (MailTemplateTestData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(data, that.data) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, data, description);
    }
}

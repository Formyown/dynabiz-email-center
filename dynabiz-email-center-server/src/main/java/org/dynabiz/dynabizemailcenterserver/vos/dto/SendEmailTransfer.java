package org.dynabiz.dynabizemailcenterserver.vos.dto;


import java.io.Serializable;
import java.util.Objects;

public class SendEmailTransfer implements Serializable {
    private String name;
    private String email;
    private String data;

    public SendEmailTransfer() {
    }

    public SendEmailTransfer(String name, String email, String data) {
        this.name = name;
        this.email = email;
        this.data = data;
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

    @Override
    public String toString() {
        return "SendEmailTransfer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SendEmailTransfer)) return false;
        SendEmailTransfer that = (SendEmailTransfer) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, data);
    }
}

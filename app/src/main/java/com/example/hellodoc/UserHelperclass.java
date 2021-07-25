package com.example.hellodoc;

public class UserHelperclass {
    String Name,Mail,Phone;

    public UserHelperclass() {

    }

    public UserHelperclass(String Name, String Mail, String Phone) {
        this.Name = Name;
        this.Mail = Mail;
        this.Phone = Phone;

    }

    public String getName1() {
        return Name;
    }

    public void setName1(String Name) {
        this.Name = Name;
    }

    public String getMail1() {
        return Mail;
    }

    public void setMail1(String Mail) {
        this.Mail = Mail;
    }

    public String getPhone1() {
        return Phone;
    }

    public void setPhone1(String Phone) {
        this.Phone = Phone;
    }


}

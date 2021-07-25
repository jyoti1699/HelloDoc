package com.example.hellodoc;

public class Userhelper {
    String name,mail,phone,Pass;

    public Userhelper() {
    }
    public Userhelper(String name, String mail, String phone, String Pass) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.Pass = Pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) { this.phone = phone; }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }


}

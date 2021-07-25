package com.example.hellodoc.HelperClass.HomeAdapter;

public class MBHelperClass {
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public MBHelperClass(String dname, String pname, String age, String time, String date, String aadhar, String contact) {
        this.dname = dname;
        this.pname = pname;
        this.age = age;
        this.time = time;
        this.date = date;
        this.aadhar = aadhar;
        this.contact = contact;
    }

    String dname,pname,age,time,date,aadhar,contact;
}

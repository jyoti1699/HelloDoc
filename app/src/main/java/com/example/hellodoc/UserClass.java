package com.example.hellodoc;

public class UserClass {
    String PName,PAge,PAadhar,dname,date,time,PContact;

    public UserClass() {

    }




    public UserClass(String PName, String PAge, String PAadhar, String dname, String date, String time, String PContact) {
        this.PName = PName;
        this.PAge = PAge;
        this.PAadhar = PAadhar;
        this.dname =  dname;
        this.date = date;
        this.time = time;
        this.PContact = PContact;

    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPAge() {
        return PAge;
    }

    public void setPAge(String PAge) { this.PAge = PAge; }

    public String getPAadhar() {
        return PAadhar;
    }

    public void setPAadhar(String PAadhar) {
        this.PAadhar = PAadhar;
    }

    public String getDname() { return dname; }

    public void setDname(String dname) { this.dname = dname; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public String getPContact() {
        return PContact;
    }

    public void setPContact(String PContact) {
        this.PContact = PContact;
    }



}

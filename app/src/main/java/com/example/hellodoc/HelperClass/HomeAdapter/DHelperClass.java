package com.example.hellodoc.HelperClass.HomeAdapter;

public class DHelperClass {
    String name,specs,addr,phone,fees,city;
    float drbar;


    public DHelperClass(String name, String specs, String addr, String phone, float drbar, String fees, String city) {
        this.name = name;
        this.specs = specs;
        this.addr = addr;
        this.phone = phone;
        this.drbar = drbar;
        this.fees = fees;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) { this.specs = specs; }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getDrbar() {
        return drbar;
    }

    public void setDrbar(int drbar) { this.drbar = drbar;}

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }
}

package com.example.hellodoc.HelperClass.HomeAdapter;

public class MOHelperClass {
    String name;
    String title;
    String adress;
    String price;
    String contact;
    String pin;
    String quantity;
    int redId;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MOHelperClass(String title, String adress, String price, String quantity, int redId, String contact, String pin, String name) {
        this.title = title;
        this.adress = adress;
        this.price = price;
        this.quantity = quantity;
        this.redId = redId;
        this.contact = contact;
        this.pin = pin;
        this.name = name;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getRedId() {
        return redId;
    }

    public void setRedId(int redId) {
        this.redId = redId;
    }


}

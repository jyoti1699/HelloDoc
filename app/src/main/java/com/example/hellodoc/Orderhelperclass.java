package com.example.hellodoc;

public class Orderhelperclass {

    String title;
    String name;
    String price;
    String adress;
    String payment;
    String quantity;
    String contact;
    String pin;
    int redID;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Orderhelperclass(String title, String name, String adress, String payment, String quantity, String contact, String pin, int redID, String price) {
        this.title = title;
        this.name = name;
        this.adress = adress;
        this.payment = payment;
        this.quantity = quantity;
        this.contact = contact;
        this.pin = pin;
        this.redID = redID;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getRedID() {
        return redID;
    }

    public void setRedID(int redID) {
        this.redID = redID;
    }



}

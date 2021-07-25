package com.example.hellodoc.HelperClass.HomeAdapter;

public class EHelperClass {
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldprice() {
        return oldprice;
    }

    public void setOldprice(String oldprice) {
        this.oldprice = oldprice;
    }

    public int getRedID() {
        return redID;
    }

    public void setRedID(int redID) {
        this.redID = redID;
    }

    public EHelperClass(String title, String price, String oldprice, int redID) {
        this.title = title;
        this.price = price;
        this.oldprice = oldprice;
        this.redID = redID;
    }

    String price;
    String oldprice;
    int redID;

}

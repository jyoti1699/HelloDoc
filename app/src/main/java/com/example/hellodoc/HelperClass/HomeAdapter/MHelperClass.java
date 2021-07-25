package com.example.hellodoc.HelperClass.HomeAdapter;

public class MHelperClass {
    int image;
    String offer,title,price,oldprice;
    float rbar;

    public MHelperClass(int image, String offer, String title, String price, String oldprice, float rbar) {
        this.image = image;
        this.offer = offer;
        this.title = title;
        this.price = price;
        this.oldprice = oldprice;
        this.rbar = rbar;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

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

    public void setOldprice(String olprice) {
        this.oldprice = oldprice;
    }
    
    public float getRbar() {
        return rbar;
    }

    public void setRbar(int rbar) { this.rbar = rbar;}
}

package com.example.hellodoc.HelperClass.HomeAdapter;

public class MostHelperClass {
    int image;
    String offer,title,price;

    public MostHelperClass(int image, String offer, String title, String price) {
        this.image = image;
        this.offer = offer;
        this.title = title;
        this.price = price;
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
}

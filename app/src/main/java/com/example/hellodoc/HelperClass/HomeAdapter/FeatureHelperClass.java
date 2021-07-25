package com.example.hellodoc.HelperClass.HomeAdapter;

public class FeatureHelperClass {
    int image;
    String title;
    String description;

    public FeatureHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public CharSequence getTitle() {
        return (CharSequence) title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CharSequence getDescription() {
        return (CharSequence) description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

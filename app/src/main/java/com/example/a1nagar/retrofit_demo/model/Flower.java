package com.example.a1nagar.retrofit_demo.model;

import android.graphics.Bitmap;

/**
 * Created by a1nagar on 6/9/15.
 */
public class Flower {
    private String category;
    private String instructions;
    private String name;
    private String photo;
    private Number price;
    private Number productId;
    private Bitmap bitmap;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Number getPrice() {
        return this.price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Number getProductId() {
        return this.productId;
    }

    public void setProductId(Number productId) {
        this.productId = productId;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}

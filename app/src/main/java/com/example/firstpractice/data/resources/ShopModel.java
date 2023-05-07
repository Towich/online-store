package com.example.firstpractice.data.resources;

public class ShopModel {
    private final String name;          // Text of Shop
    private final int idDrawableImage;  // Image of Shop

    public ShopModel(String name, int idDrawableImage) {
        this.name = name;
        this.idDrawableImage = idDrawableImage;
    }

    public String getName() {
        return name;
    }

    public int getIdDrawableImage() {
        return idDrawableImage;
    }
}

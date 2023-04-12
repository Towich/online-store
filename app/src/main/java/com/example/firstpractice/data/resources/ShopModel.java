package com.example.firstpractice.data.resources;

public class ShopModel {
    private final String name;
    private final int idDrawableImage;

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

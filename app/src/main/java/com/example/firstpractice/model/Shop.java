package com.example.firstpractice.model;

public class Shop {
    private final String name;
    private final int idDrawableImage;

    public Shop(String name, int idDrawableImage) {
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

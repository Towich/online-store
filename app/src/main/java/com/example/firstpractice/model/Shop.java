package com.example.firstpractice.model;

import com.example.firstpractice.R;

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

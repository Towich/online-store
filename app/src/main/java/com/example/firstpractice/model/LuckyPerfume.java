package com.example.firstpractice.model;

import android.graphics.drawable.Drawable;

public class LuckyPerfume {
    private final int imagePerfume;
    private final String namePerfume;

    public LuckyPerfume(int imagePerfume, String namePerfume) {
        this.imagePerfume = imagePerfume;
        this.namePerfume = namePerfume;
    }

    public int getImagePerfume() {
        return imagePerfume;
    }

    public String getNamePerfume() {
        return namePerfume;
    }
}

package com.example.firstpractice.data.resources;

public class LuckyPerfumeModel {
    private final int imagePerfume;
    private final String namePerfume;

    public LuckyPerfumeModel(int imagePerfume, String namePerfume) {
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

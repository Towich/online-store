package com.example.firstpractice.data.resources;

public class LuckyPerfumeModel {
    private final int imagePerfume;     // id of perfume's Image
    private final String namePerfume;   // perfume's name

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

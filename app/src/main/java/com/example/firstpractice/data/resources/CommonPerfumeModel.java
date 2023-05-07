package com.example.firstpractice.data.resources;

import androidx.annotation.NonNull;

public class CommonPerfumeModel {
    private String name;    // perfume's name
    private int price;      // perfume's price

    public CommonPerfumeModel(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @NonNull
    public String getName(){
        return name;
    }
    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}

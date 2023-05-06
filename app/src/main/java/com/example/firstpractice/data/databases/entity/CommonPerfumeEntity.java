package com.example.firstpractice.data.databases.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.firstpractice.data.resources.CommonPerfumeModel;

@Entity(tableName = "common_perfume_table")
public class CommonPerfumeEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private int price;

    public CommonPerfumeEntity(String name, int price) {
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

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public CommonPerfumeModel toModel(){
        return new CommonPerfumeModel(name, price);
    }
}

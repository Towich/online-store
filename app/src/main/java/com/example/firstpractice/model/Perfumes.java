package com.example.firstpractice.model;

import com.example.firstpractice.MainContract;

import java.util.ArrayList;
import java.util.List;

public class Perfumes implements MainContract.Repository {
    private List<String> store_items;
    private boolean premium;

    public Perfumes(boolean _premium){
        store_items = new ArrayList<String>();
        premium = _premium;
    }

    public List<String> CreateListOfItems(int quantity){
        if(premium) {
            for (int i = 1; i <= quantity; i++) {
                store_items.add("Premium perfume " + i);
            }
        }
        else{
            for (int i = 1; i <= quantity; i++) {
                store_items.add("Perfume " + i);
            }
        }
        return store_items;
    }
}

package com.example.firstpractice.dataresouces;

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
                int rub = 5000 + (1000 * i) % 32000;
                store_items.add("Premium perfume " + i + " | " + rub + " rubles");
            }
        }
        else{
            for (int i = 1; i <= quantity; i++) {
                int rub = 2000 + (500 * i) % 8000;
                store_items.add("Perfume " + i + " | " + rub + " rubles");
            }
        }
        return store_items;
    }
}

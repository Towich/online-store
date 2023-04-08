package com.example.firstpractice.domain;

import com.example.firstpractice.model.Shop;

public class ShopRepository {
    private final Shop firstShop;
    private final Shop secondShop;

    public ShopRepository(Shop firstShop, Shop secondShop) {
        this.firstShop = firstShop;
        this.secondShop = secondShop;
    }

    public Shop getFirstShop() {
        return firstShop;
    }

    public Shop getSecondShop() {
        return secondShop;
    }
}

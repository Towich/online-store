package com.example.firstpractice.data.repositories;

import com.example.firstpractice.data.resources.ShopModel;

public class ShopRepository {
    private ShopModel[] shopModels;

    public ShopRepository(ShopModel firstShopModel, ShopModel secondShopModel) {
        this.shopModels[0] = firstShopModel;
        this.shopModels[1] = secondShopModel;
    }

    public ShopModel getFirstShop() {
        return shopModels[0];
    }

    public ShopModel getSecondShop() {
        return shopModels[1];
    }
}

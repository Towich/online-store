package com.example.firstpractice.data.repositories;

import com.example.firstpractice.data.resources.ShopModel;
import com.example.firstpractice.data.sources.ShopDataSource;

public class ShopRepository {
    private final ShopModel[] shopModels;

    public ShopRepository() {
        shopModels = new ShopModel[2];
        this.shopModels[0] = new ShopModel(ShopDataSource.textFirstShop, ShopDataSource.imageFirstShop);
        this.shopModels[1] = new ShopModel(ShopDataSource.textSecondShop, ShopDataSource.imageSecondShop);
    }

    public ShopModel getFirstShop() {
        return shopModels[0];
    }

    public ShopModel getSecondShop() {
        return shopModels[1];
    }
}

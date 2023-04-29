package com.example.firstpractice.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.firstpractice.data.resources.ShopModel;
import com.example.firstpractice.data.sources.ShopDataSource;

import java.util.List;

public class ShopRepository {
    public LiveData<List<ShopModel>> getData() {
        return ShopDataSource.createShopsList();
    }
}

package com.example.firstpractice.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.firstpractice.data.resources.ShopModel;
import com.example.firstpractice.data.sources.ShopDataSource;

import java.util.List;

public class ShopRepository {

    // Get LiveData List from DataSource
    public LiveData<List<ShopModel>> getData() {
        return ShopDataSource.createShopsList();
    }
}

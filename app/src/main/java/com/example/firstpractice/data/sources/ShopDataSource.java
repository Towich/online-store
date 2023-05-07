package com.example.firstpractice.data.sources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.R;
import com.example.firstpractice.data.resources.ShopModel;

import java.util.ArrayList;
import java.util.List;

public class ShopDataSource {

    // Create a LiveData list of Shops
    public static LiveData<List<ShopModel>> createShopsList(){
        MutableLiveData<List<ShopModel>> list = new MutableLiveData<>();

        ArrayList<ShopModel> shopModels = new ArrayList<>();
        shopModels.add(new ShopModel("That is the first shop, located on 11-ya Parkovaya 36", R.drawable.shop1));
        shopModels.add(new ShopModel("It's the second shop, it located on Saratovskoe Shosse 21", R.drawable.shop2));

        list.setValue(shopModels);
        return list;
    }
}


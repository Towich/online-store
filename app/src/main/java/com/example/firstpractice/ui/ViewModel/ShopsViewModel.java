package com.example.firstpractice.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.R;
import com.example.firstpractice.data.resources.ShopModel;
import com.example.firstpractice.data.sources.ShopDataSource;
import com.example.firstpractice.data.repositories.ShopRepository;

public class ShopsViewModel extends ViewModel {

    private final MutableLiveData<ShopRepository> shopRepository; // LiveData


    public ShopsViewModel(){
        shopRepository = new MutableLiveData<>(
                new ShopRepository(
                        new ShopModel("", R.drawable.logo_image),
                        new ShopModel("", R.drawable.logo_image)
                )
        );
    }

    public LiveData<ShopRepository> getShopRepository(){
        return shopRepository;
    }

    public void createShops(){
        shopRepository.setValue(new ShopRepository(
                new ShopModel(ShopDataSource.textFirstShop, ShopDataSource.imageFirstShop),
                new ShopModel(ShopDataSource.textSecondShop, ShopDataSource.imageSecondShop)
        ));
    }

}

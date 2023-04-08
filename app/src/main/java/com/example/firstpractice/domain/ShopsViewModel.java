package com.example.firstpractice.domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.R;
import com.example.firstpractice.model.Shop;
import com.example.firstpractice.model.ShopStorage;

public class ShopsViewModel extends ViewModel {
    private final MutableLiveData<ShopRepository> shopRepository =
            new MutableLiveData<ShopRepository>(new ShopRepository(new Shop("", R.drawable.logo_image), new Shop("", R.drawable.logo_image)));

    public LiveData<ShopRepository> getShopRepository(){
        return shopRepository;
    }

    private String getShopName(boolean first){
        if(first)
            return shopRepository.getValue().getFirstShop().getName();
        else
            return shopRepository.getValue().getSecondShop().getName();
    }

    private int getImage(boolean first){
        if(first)
            return shopRepository.getValue().getFirstShop().getIdDrawableImage();
        else
            return shopRepository.getValue().getSecondShop().getIdDrawableImage();
    }

    public void createShops(){
        shopRepository.setValue(new ShopRepository(
                new Shop(ShopStorage.textFirstShop, ShopStorage.imageFirstShop),
                new Shop(ShopStorage.textSecondShop, ShopStorage.imageSecondShop)
        ));
    }

}
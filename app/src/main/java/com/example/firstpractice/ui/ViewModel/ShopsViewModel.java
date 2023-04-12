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
                new ShopRepository()
        );
    }

    public LiveData<ShopRepository> getShopRepository(){
        return shopRepository;
    }

    public void createShops(){
        shopRepository.setValue(new ShopRepository());
    }

    public String getName(boolean firstShop) {
        if(firstShop)
            return shopRepository.getValue().getFirstShop().getName();
        else
            return shopRepository.getValue().getSecondShop().getName();
    }

    public int getIdDrawableImage(boolean firstShop) {
        if(firstShop)
            return shopRepository.getValue().getFirstShop().getIdDrawableImage();
        else
            return shopRepository.getValue().getSecondShop().getIdDrawableImage();
    }

}

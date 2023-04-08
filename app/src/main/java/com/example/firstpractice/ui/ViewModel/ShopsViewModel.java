package com.example.firstpractice.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.R;
import com.example.firstpractice.dataresouces.Shop;
import com.example.firstpractice.dataresouces.ShopStorage;
import com.example.firstpractice.datarepositories.ShopRepository;

public class ShopsViewModel extends ViewModel {
    private final MutableLiveData<ShopRepository> shopRepository =
            new MutableLiveData<>(new ShopRepository(new Shop("", R.drawable.logo_image), new Shop("", R.drawable.logo_image)));

    public LiveData<ShopRepository> getShopRepository(){
        return shopRepository;
    }

    public void createShops(){
        shopRepository.setValue(new ShopRepository(
                new Shop(ShopStorage.textFirstShop, ShopStorage.imageFirstShop),
                new Shop(ShopStorage.textSecondShop, ShopStorage.imageSecondShop)
        ));
    }

}

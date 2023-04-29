package com.example.firstpractice.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.R;
import com.example.firstpractice.data.resources.ShopModel;
import com.example.firstpractice.data.sources.ShopDataSource;
import com.example.firstpractice.data.repositories.ShopRepository;

import java.util.List;

public class ShopsViewModel extends ViewModel {

    public LiveData<List<ShopModel>> shops; // LiveData

    public ShopsViewModel(){
        ShopRepository shopRepository = new ShopRepository();
        shops = shopRepository.getData();
    }
}

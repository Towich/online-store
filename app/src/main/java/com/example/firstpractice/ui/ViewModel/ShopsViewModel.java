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

    public LiveData<List<ShopModel>> shops; // LiveData of list all Shops

    public ShopsViewModel(){
        ShopRepository shopRepository = new ShopRepository();
        shops = shopRepository.getData();
    }

    public int getIdDrawable(int index){
        return shops.getValue().get(index).getIdDrawableImage();
    }

    public String getName(int index){
        return shops.getValue().get(index).getName();
    }
}

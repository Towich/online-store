package com.example.firstpractice.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.data.resources.LuckyPerfumeModel;
import com.example.firstpractice.data.resources.ShopModel;
import com.example.firstpractice.data.sources.LuckyPerfumeDataSource;
import com.example.firstpractice.data.sources.ShopDataSource;

import java.util.List;

public class LuckyPerfumeRepository {
    public MutableLiveData<LuckyPerfumeModel> getData(int index) {
        return LuckyPerfumeDataSource.createLuckyPerfume(index);
    }
}

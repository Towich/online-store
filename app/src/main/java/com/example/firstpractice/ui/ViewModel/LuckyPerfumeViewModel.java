package com.example.firstpractice.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.data.repositories.LuckyPerfumeRepository;
import com.example.firstpractice.data.repositories.ShopRepository;
import com.example.firstpractice.data.resources.LuckyPerfumeModel;
import com.example.firstpractice.data.resources.ShopModel;
import com.example.firstpractice.data.sources.LuckyPerfumeDataSource;

import java.util.List;
import java.util.Random;

public class LuckyPerfumeViewModel extends ViewModel {

    LuckyPerfumeRepository luckyPerfumeRepository;
    public int current;
    public MutableLiveData<LuckyPerfumeModel> luckyPerfume; // LiveData

    public LuckyPerfumeViewModel(){
        luckyPerfumeRepository = new LuckyPerfumeRepository();
        luckyPerfume = luckyPerfumeRepository.getData(current);
    }
    public LuckyPerfumeModel getPerfume(){
        return luckyPerfume.getValue();
    }

    public void rollLuckyPerfume(){
        Random random = new Random();
        current = random.nextInt(5);
        luckyPerfume.setValue(luckyPerfumeRepository.getData(current).getValue());
    }
}

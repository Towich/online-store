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

    LuckyPerfumeRepository luckyPerfumeRepository;  // Repository
    public int current; // Index of current showing perfume
    public MutableLiveData<LuckyPerfumeModel> luckyPerfume; // LiveData

    public LuckyPerfumeViewModel(){
        current = 0;
        luckyPerfumeRepository = new LuckyPerfumeRepository();
        luckyPerfume = luckyPerfumeRepository.getData(current);
    }
    public LuckyPerfumeModel getPerfume(){
        return luckyPerfume.getValue();
    }

    // Roll lucky perfume
    public void rollLuckyPerfume(){
        Random random = new Random();
        current = random.nextInt(5);

        // Set new lucky perfume
        luckyPerfume.setValue(luckyPerfumeRepository.getData(current).getValue());
    }
}

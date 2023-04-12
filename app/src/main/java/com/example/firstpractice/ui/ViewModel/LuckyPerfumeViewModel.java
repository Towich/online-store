package com.example.firstpractice.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.data.resources.LuckyPerfumeModel;
import com.example.firstpractice.data.sources.LuckyPerfumeDataSource;

import java.util.Random;

public class LuckyPerfumeViewModel extends ViewModel {

    private final MutableLiveData<LuckyPerfumeModel> luckyPerfume; // LiveData

    public LuckyPerfumeViewModel(){
        luckyPerfume = new MutableLiveData<>(new LuckyPerfumeModel(0, null));
    }

    // Get LiveData
    public LiveData<LuckyPerfumeModel> getLuckyPerfume(){
        return luckyPerfume;
    }

    // Roll the lucky perfume
    public void rollLuckyPerfume(){
        Random random = new Random();
        int randInt = random.nextInt(5);
        luckyPerfume.setValue(
                new LuckyPerfumeModel(LuckyPerfumeDataSource.getImage(randInt), LuckyPerfumeDataSource.getName(randInt))
        );
    }
}

package com.example.firstpractice.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.R;
import com.example.firstpractice.dataresouces.LuckyPerfume;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LuckyPerfumeViewModel extends ViewModel {

    private final MutableLiveData<LuckyPerfume> luckyPerfume =
            new MutableLiveData<>(new LuckyPerfume(0, null));

    public LiveData<LuckyPerfume> getLuckyPerfume(){
        return luckyPerfume;
    }

    private String getLuckyName(int roll){
        List<String> names = new ArrayList<>();
        names.add("Tom Ford Lost Cherry");
        names.add("Franck Boclet");
        names.add("Baccarat Rouge 540");
        names.add("Tiffany & CO");
        names.add("LACOSTE L.12.12");

        return names.get(roll);
    }

    private int getImage(int roll){
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.tomfordlostcherry);
        images.add(R.drawable.franckboclet);
        images.add(R.drawable.baccaratrouge540);
        images.add(R.drawable.tiffany_co);
        images.add(R.drawable.lacoste_l_12_12);

        return images.get(roll);
    }

    public void rollLuckyPerfume(){
        List<String> names = new ArrayList<>();
        Random random = new Random();
        int randInt = random.nextInt(5);
        luckyPerfume.setValue(
                new LuckyPerfume(getImage(randInt), getLuckyName(randInt))
        );
    }
}

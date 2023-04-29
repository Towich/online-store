package com.example.firstpractice.data.sources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.R;
import com.example.firstpractice.data.repositories.ShopRepository;
import com.example.firstpractice.data.resources.LuckyPerfumeModel;
import com.example.firstpractice.data.resources.ShopModel;

import java.util.ArrayList;
import java.util.List;

public class LuckyPerfumeDataSource {
    public static MutableLiveData<LuckyPerfumeModel> createLuckyPerfume(int index){
        MutableLiveData<LuckyPerfumeModel> perfume = new MutableLiveData<>();

        ArrayList<LuckyPerfumeModel> luckyPerfumeModels = new ArrayList<>();
        luckyPerfumeModels.add(new LuckyPerfumeModel(R.drawable.tomfordlostcherry, "Tom Ford Lost Cherry"));
        luckyPerfumeModels.add(new LuckyPerfumeModel(R.drawable.franckboclet, "Franck Boclet"));
        luckyPerfumeModels.add(new LuckyPerfumeModel(R.drawable.baccaratrouge540, "Baccarat Rouge 540"));
        luckyPerfumeModels.add(new LuckyPerfumeModel(R.drawable.tiffany_co, "Tiffany & CO"));
        luckyPerfumeModels.add(new LuckyPerfumeModel(R.drawable.lacoste_l_12_12, "LACOSTE L.12.12"));

        perfume.setValue(luckyPerfumeModels.get(index));
        return perfume;
    }
}

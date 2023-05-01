package com.example.firstpractice.ui.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.firstpractice.data.databases.entity.CommonPerfumeEntity;
import com.example.firstpractice.data.repositories.CommonPerfumeRepository;

import java.util.List;

public class CommonPerfumeViewModel extends AndroidViewModel {
    private CommonPerfumeRepository mRepository;
    private final LiveData<List<CommonPerfumeEntity>> mAllCommonPerfumes;

    public CommonPerfumeViewModel(Application application){
        super(application);
        mRepository = new CommonPerfumeRepository(application);
        mAllCommonPerfumes = mRepository.getAllCommonPerfumes();
    }

    public LiveData<List<CommonPerfumeEntity>> getAllCommonPerfumes(){ return mAllCommonPerfumes; }
    public void insert(CommonPerfumeEntity perfume){
        mRepository.insert(perfume);
    }
}

package com.example.firstpractice.data.repositories;

import android.app.Application;
import android.os.Build;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.firstpractice.data.databases.dao.CommonPerfumeDao;
import com.example.firstpractice.data.databases.entity.CommonPerfumeEntity;
import com.example.firstpractice.data.databases.roomDatabase.CommonPerfumeDatabase;
import com.example.firstpractice.data.resources.CommonPerfumeModel;

import java.util.List;
import java.util.stream.Collectors;

public class CommonPerfumeRepository {
    private CommonPerfumeDao mCommonPerfumeDao;
    private LiveData<List<CommonPerfumeModel>> mAllCommonPerfumes;

    public CommonPerfumeRepository(Application application){
        CommonPerfumeDatabase db = CommonPerfumeDatabase.getDatabase(application);
        mCommonPerfumeDao = db.commonPerfumeDao();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mAllCommonPerfumes = Transformations.map(mCommonPerfumeDao.getAllCommonPerfumes(), entities -> entities.stream()
                    .map(CommonPerfumeEntity::toModel).collect(Collectors.toList()));
        }
    }

    public LiveData<List<CommonPerfumeModel>> getAllCommonPerfumes(){ return mAllCommonPerfumes; }

    public void insert(CommonPerfumeEntity commonPerfume){
        CommonPerfumeDatabase.databaseWriteExecutor.execute(() -> {
            mCommonPerfumeDao.insert(commonPerfume);
        });
    }
}

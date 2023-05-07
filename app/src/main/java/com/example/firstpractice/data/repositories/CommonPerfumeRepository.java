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
    private CommonPerfumeDao mCommonPerfumeDao;                     // Data Access Object
    private LiveData<List<CommonPerfumeModel>> mAllCommonPerfumes;  // LiveData of all perfumes from a database

    public CommonPerfumeRepository(Application application){
        CommonPerfumeDatabase db = CommonPerfumeDatabase.getDatabase(application); // get Database
        mCommonPerfumeDao = db.commonPerfumeDao(); // get DAO from Database

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // Transform List of Entities to List of Models
            mAllCommonPerfumes = Transformations.map(mCommonPerfumeDao.getAllCommonPerfumes(), entities -> entities.stream()
                    .map(CommonPerfumeEntity::toModel).collect(Collectors.toList()));
        }
    }

    public LiveData<List<CommonPerfumeModel>> getAllCommonPerfumes(){ return mAllCommonPerfumes; }

    // Insert new Entity in Database
    public void insert(CommonPerfumeEntity commonPerfume){
        CommonPerfumeDatabase.databaseWriteExecutor.execute(() -> {
            mCommonPerfumeDao.insert(commonPerfume);
        });
    }
}

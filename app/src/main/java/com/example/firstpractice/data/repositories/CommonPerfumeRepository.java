package com.example.firstpractice.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.firstpractice.data.databases.dao.CommonPerfumeDao;
import com.example.firstpractice.data.databases.entity.CommonPerfumeEntity;
import com.example.firstpractice.data.databases.roomDatabase.CommonPerfumeDatabase;

import java.util.List;

public class CommonPerfumeRepository {
    private CommonPerfumeDao mCommonPerfumeDao;
    private LiveData<List<CommonPerfumeEntity>> mAllCommonPerfumes;

    public CommonPerfumeRepository(Application application){
        CommonPerfumeDatabase db = CommonPerfumeDatabase.getDatabase(application);
        mCommonPerfumeDao = db.commonPerfumeDao();
        mAllCommonPerfumes = mCommonPerfumeDao.getAllCommonPerfumes();
    }

    public LiveData<List<CommonPerfumeEntity>> getAllCommonPerfumes(){ return mAllCommonPerfumes; }

    public void insert(CommonPerfumeEntity commonPerfume){
        CommonPerfumeDatabase.databaseWriteExecutor.execute(() -> {
            mCommonPerfumeDao.insert(commonPerfume);
        });
    }
}

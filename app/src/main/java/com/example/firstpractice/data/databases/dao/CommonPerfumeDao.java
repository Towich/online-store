package com.example.firstpractice.data.databases.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.firstpractice.data.databases.entity.CommonPerfumeEntity;

import java.util.List;

@Dao
public interface CommonPerfumeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CommonPerfumeEntity perfume);

    @Query("DELETE FROM common_perfume_table")
    void deleteAll();

    @Query("SELECT * FROM common_perfume_table")
    LiveData<List<CommonPerfumeEntity>> getAllCommonPerfumes();
}

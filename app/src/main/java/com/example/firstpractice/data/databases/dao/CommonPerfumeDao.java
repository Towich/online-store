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

    // Insert a new perfume to database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CommonPerfumeEntity perfume);

    // Delete all perfumes from a database
    @Query("DELETE FROM common_perfume_table")
    void deleteAll();

    // Get all perfumes from a database
    @Query("SELECT * FROM common_perfume_table")
    LiveData<List<CommonPerfumeEntity>> getAllCommonPerfumes();
}

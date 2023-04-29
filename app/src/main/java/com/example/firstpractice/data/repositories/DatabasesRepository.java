package com.example.firstpractice.data.repositories;

import android.content.Context;

import com.example.firstpractice.data.sources.AppSpecificDataSource;
import com.example.firstpractice.data.sources.SharedPreferencesDataSource;
import com.example.firstpractice.data.sources.SharedStorageDataSource;

public class DatabasesRepository {

    private final AppSpecificDataSource appSpecificDataSource;
    private final SharedStorageDataSource sharedStorageDataSource;
    private final SharedPreferencesDataSource sharedPreferencesDataSource;

    public DatabasesRepository(){
        appSpecificDataSource = new AppSpecificDataSource();
        sharedStorageDataSource = new SharedStorageDataSource();
        sharedPreferencesDataSource = new SharedPreferencesDataSource();
    }

    // #1 App-specific storage
    public void createFileAppSpecific(Context context) { appSpecificDataSource.createFile(context); }
    public void saveAppSpecific(String toSave){
        appSpecificDataSource.save(toSave);
    }
    public String loadAppSpecific(){
        return appSpecificDataSource.load();
    }

    // #2 SharedStorage
    public void createFileSharedStorage(Context context) {
        sharedStorageDataSource.createFile(context);
    }
    public void saveSharedStorage(String dataToSave) {
        sharedStorageDataSource.save(dataToSave);
    }
    public String loadSharedStorage() {
        return sharedStorageDataSource.load();
    }

    // #3 SharedPreferences
    public void createSharedPreferences(Context context) {
        sharedPreferencesDataSource.create(context);
    }
    public void saveSharedPreferences(String dataToSave) {
        sharedPreferencesDataSource.save(dataToSave);
    }
    public String loadSharedPreferences() {
        return sharedPreferencesDataSource.load();
    }
}

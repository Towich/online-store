package com.example.firstpractice.data.repositories;

import android.content.Context;

import com.example.firstpractice.data.sources.AppSpecificDataSource;
import com.example.firstpractice.data.sources.SharedPreferencesDataSource;
import com.example.firstpractice.data.sources.ExternalStorageDataSource;

public class DatabasesRepository {

    private final AppSpecificDataSource appSpecificDataSource;
    private final ExternalStorageDataSource externalStorageDataSource;
    private final SharedPreferencesDataSource sharedPreferencesDataSource;

    public DatabasesRepository(){
        appSpecificDataSource = new AppSpecificDataSource();
        externalStorageDataSource = new ExternalStorageDataSource();
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
        externalStorageDataSource.createFile(context);
    }
    public void saveSharedStorage(String dataToSave) {
        externalStorageDataSource.save(dataToSave);
    }
    public String loadSharedStorage() {
        return externalStorageDataSource.load();
    }

    // #3 SharedPreferences
    public void createSharedPreferences(Context context) {
        sharedPreferencesDataSource.createFile(context);
    }
    public void saveSharedPreferences(String dataToSave) {
        sharedPreferencesDataSource.save(dataToSave);
    }
    public String loadSharedPreferences() {
        return sharedPreferencesDataSource.load();
    }
}

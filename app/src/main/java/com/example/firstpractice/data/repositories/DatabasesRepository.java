package com.example.firstpractice.data.repositories;

import android.content.Context;

import com.example.firstpractice.data.sources.AppSpecificDataSource;
import com.example.firstpractice.data.sources.SharedStorageDataSource;

public class DatabasesRepository {

    private AppSpecificDataSource appSpecificDataSource;
    private SharedStorageDataSource sharedStorageDataSource;

    public DatabasesRepository(){
        appSpecificDataSource = new AppSpecificDataSource();
        sharedStorageDataSource = new SharedStorageDataSource();
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
}

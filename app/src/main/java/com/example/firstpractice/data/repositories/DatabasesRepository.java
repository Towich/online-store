package com.example.firstpractice.data.repositories;

import android.content.Context;

import com.example.firstpractice.data.resources.DatabasesDataSource;

public class DatabasesRepository {

    private DatabasesDataSource databasesDataSource;

    public DatabasesRepository(){
        databasesDataSource = new DatabasesDataSource();
    }

    // #1 App-specific storage

    public void createFileAppSpecific(Context context) {
        databasesDataSource.createFileAppSpecific(context);
    }
    public void saveAppSpecific(String toSave){
        databasesDataSource.saveAppSpecific(toSave);
    }
    public String loadAppSpecific(){
        return databasesDataSource.loadAppSpecific();
    }

    // #2 SharedStorage

    public void createFileSharedStorage(Context context) {
        databasesDataSource.createFileSharedStorage(context);
    }
    public void saveSharedStorage(String dataToSave) {
        databasesDataSource.saveSharedStorage(dataToSave);
    }
    public String loadSharedStorage() {
        return databasesDataSource.loadSharedStorage();
    }
}

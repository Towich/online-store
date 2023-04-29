package com.example.firstpractice.ui.ViewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.data.repositories.DatabasesRepository;

public class DatabasesViewModel extends ViewModel {

    private final MutableLiveData<DatabasesRepository> saveFile; // LiveData

    public DatabasesViewModel(){
        saveFile = new MutableLiveData<>(new DatabasesRepository());
    }

    // Get LiveData
    public LiveData<DatabasesRepository> getAppSpecific(){
        return saveFile;
    }

    // #1 App-specific storage

    public void createAppSpecific(Context context){
        saveFile.getValue().createFileAppSpecific(context);
    }
    public void saveDataAppSpecific(String dataToSave){
        saveFile.getValue().saveAppSpecific(dataToSave);
    }
    public String loadDataAppSpecific(){
        return saveFile.getValue().loadAppSpecific();
    }

    // #2 SharedStorage

    public void createSharedStorage(Context context){
        saveFile.getValue().createFileSharedStorage(context);
    }
    public void saveSharedStorage(String dataToSave){
        saveFile.getValue().saveSharedStorage(dataToSave);
    }
    public String loadSharedStorage(){
        return saveFile.getValue().loadSharedStorage();
    }
}

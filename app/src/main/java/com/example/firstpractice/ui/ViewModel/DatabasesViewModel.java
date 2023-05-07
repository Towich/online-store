package com.example.firstpractice.ui.ViewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.data.repositories.DatabasesRepository;

public class DatabasesViewModel extends ViewModel {
    private final DatabasesRepository repository;   // Repository

    public DatabasesViewModel(){
        repository = new DatabasesRepository();
    }

    // #1 App-specific storage
    public void createAppSpecific(Context context){
        repository.createFileAppSpecific(context);
    }
    public void saveDataAppSpecific(String dataToSave){
        repository.saveAppSpecific(dataToSave);
    }
    public String loadDataAppSpecific(){
        return repository.loadAppSpecific();
    }

    // #2 SharedStorage
    public void createSharedStorage(Context context){
        repository.createFileSharedStorage(context);
    }
    public void saveSharedStorage(String dataToSave){
        repository.saveSharedStorage(dataToSave);
    }
    public String loadSharedStorage(){
        return repository.loadSharedStorage();
    }

    // #3 SharedPreferences
    public void createSharedPreferences(Context context) {
        repository.createSharedPreferences(context);
    }
    public void saveSharedPreferences(String dataToSave) {
        repository.saveSharedPreferences(dataToSave);
    }
    public String loadSharedPreferences() {
        return repository.loadSharedPreferences();
    }
}

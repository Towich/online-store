package com.example.firstpractice.ui.ViewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.data.resources.AppSpecificModel;

public class DatabasesViewModel extends ViewModel {

    private final MutableLiveData<AppSpecificModel> saveFile; // LiveData

    public DatabasesViewModel(){
        saveFile = new MutableLiveData<>(new AppSpecificModel());
    }

    // Get LiveData
    public LiveData<AppSpecificModel> getAppSpecific(){
        return saveFile;
    }

    public void createAppSpecific(Context context){
        saveFile.getValue().createFile(context);
    }
    
    public void saveDataAppSpecific(String dataToSave){
        saveFile.getValue().save(dataToSave);
    }
    
    public String loadDataAppSpecific(){
        return saveFile.getValue().load();
    }
}

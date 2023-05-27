package com.example.firstpractice.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.data.api.vk.PlaceholderVK;
import com.example.firstpractice.data.resources.LuckyPerfumeModel;
import com.example.firstpractice.data.sources.LuckyPerfumeDataSource;
import com.example.firstpractice.data.sources.VKDataSource;

public class VKRepository {

    private MutableLiveData<Boolean> resultStatus;
    private MutableLiveData<PlaceholderVK> statusHolder;

    public VKRepository(){
        resultStatus = VKDataSource.getResultStatusLiveData();
        statusHolder = VKDataSource.getPlaceholderVKMutableLiveData();
    }

    public MutableLiveData<Boolean> getResultStatus() {
        return resultStatus;
    }

    public MutableLiveData<PlaceholderVK> getPlaceholderVK() {
        return statusHolder;
    }

    public void setStatusVK(String newStatus){
        VKDataSource.setStatusVK(newStatus);
    }

    public void getStatusVK(){
        VKDataSource.getStatusVK();
    }
}

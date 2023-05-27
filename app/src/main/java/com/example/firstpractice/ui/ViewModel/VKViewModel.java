package com.example.firstpractice.ui.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.data.api.vk.PlaceholderVK;
import com.example.firstpractice.data.repositories.VKRepository;

public class VKViewModel extends AndroidViewModel {

    private final VKRepository mVKRepository;
    private MutableLiveData<Boolean> resultStatus;
    private MutableLiveData<PlaceholderVK> statusHolder;

    public VKViewModel(@NonNull Application application) {
        super(application);

        mVKRepository = new VKRepository();

        resultStatus = mVKRepository.getResultStatus();
        statusHolder = mVKRepository.getPlaceholderVK();
    }

    public MutableLiveData<Boolean> getResultStatus() {
        return resultStatus;
    }

    public MutableLiveData<PlaceholderVK> getStatusHolder() {
        return statusHolder;
    }
    public String getStringStatusVK(){
        return statusHolder.getValue().getResponseVK().getText();
    }

    public void setStatusVK(String newStatus){
        mVKRepository.setStatusVK(newStatus);
    }

    public void getStatusVK(){
        mVKRepository.getStatusVK();
    }




}

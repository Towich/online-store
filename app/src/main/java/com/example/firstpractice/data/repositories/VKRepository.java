package com.example.firstpractice.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.data.api.vk.PlaceholderVK;
import com.example.firstpractice.data.resources.LuckyPerfumeModel;
import com.example.firstpractice.data.sources.LuckyPerfumeDataSource;
import com.example.firstpractice.data.sources.VKDataSource;

public class VKRepository {

    private MutableLiveData<Boolean> resultStatus;
    private MutableLiveData<PlaceholderVK> statusHolder;

    public MutableLiveData<Boolean> getResultStatus() {
        return VKDataSource.getResultStatus();
    }

    public MutableLiveData<PlaceholderVK> getPlaceholderVK() {
        return VKDataSource.getPlaceholderVK();
    }
}

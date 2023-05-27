package com.example.firstpractice.data.sources;

import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.data.api.vk.PlaceholderVK;

public class VKDataSource {
    public final static String URL_API = "https://api.vk.com/method/";

    public static MutableLiveData<Boolean> getResultStatus(){
        MutableLiveData<Boolean> resultStatusLiveData = new MutableLiveData<>();
        return resultStatusLiveData;
    }
    public static MutableLiveData<PlaceholderVK> getPlaceholderVK(){
        MutableLiveData<PlaceholderVK> placeholderVKMutableLiveData = new MutableLiveData<>();
        return placeholderVKMutableLiveData;
    }
}

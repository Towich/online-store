package com.example.firstpractice.data.sources;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.data.api.RetrofitFactory;
import com.example.firstpractice.data.api.RetrofitFactoryVK;
import com.example.firstpractice.data.api.vk.PlaceholderVK;
import com.example.firstpractice.data.api.vk.StatusVKAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VKDataSource {
    public final static String URL_API = "https://api.vk.com/method/";

    static MutableLiveData<Boolean> resultStatusLiveData;
    static MutableLiveData<PlaceholderVK> placeholderVKMutableLiveData;

    public VKDataSource() {

        placeholderVKMutableLiveData = new MutableLiveData<>();
    }

    public static void setStatusVK(String newStatus){
        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        StatusVKAPI statusVKAPI = retrofit.create(StatusVKAPI.class);
        Call<PlaceholderVK> call = statusVKAPI.setStatus(newStatus);

        call.enqueue(new Callback<PlaceholderVK>() {
            @Override
            public void onResponse(Call<PlaceholderVK> call, Response<PlaceholderVK> response) {
                if(!response.isSuccessful()) {
                    Log.e("ERROR", response.toString());
                    resultStatusLiveData.setValue(true);
                    return;
                }
                resultStatusLiveData.setValue(true);
            }

            @Override
            public void onFailure(Call<PlaceholderVK> call, Throwable t) {
                resultStatusLiveData.setValue(true);
            }
        });
    }
    public static void getStatusVK(){
        Retrofit retrofit = RetrofitFactoryVK.getRetrofit(URL_API);
        StatusVKAPI statusVKAPI = retrofit.create(StatusVKAPI.class);
        Call<PlaceholderVK> call = statusVKAPI.getStatus();

        call.enqueue(new Callback<PlaceholderVK>() {
            @Override
            public void onResponse(Call<PlaceholderVK> call, Response<PlaceholderVK> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", response.body().getResponseVK().getText());
                    placeholderVKMutableLiveData.setValue(response.body());

                } else {
                    Log.d("Ей", "Вау!");
                    placeholderVKMutableLiveData.setValue(null);
                    return;
                }
            }
            @Override
            public void onFailure(Call<PlaceholderVK> call, Throwable t) {
                Log.d("Ей", "Ошибка!!" + t.toString());
                placeholderVKMutableLiveData.setValue(null);
            }
        });
    }

    public static MutableLiveData<Boolean> getResultStatusLiveData() {
        resultStatusLiveData = new MutableLiveData<>();
        return resultStatusLiveData;
    }

    public static MutableLiveData<PlaceholderVK> getPlaceholderVKMutableLiveData() {
        placeholderVKMutableLiveData = new MutableLiveData<>();
        return placeholderVKMutableLiveData;

    }
}

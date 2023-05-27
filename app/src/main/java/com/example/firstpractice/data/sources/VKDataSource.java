package com.example.firstpractice.data.sources;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.data.api.RetrofitFactory;
import com.example.firstpractice.data.api.RetrofitFactoryVK;
import com.example.firstpractice.data.api.vk.PlaceholderSetStatusVK;
import com.example.firstpractice.data.api.vk.PlaceholderVK;
import com.example.firstpractice.data.api.vk.StatusVKAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VKDataSource {
    public final static String URL_API = "https://api.vk.com/method/";
    public final static String ACCESS_TOKEN = "vk1.a.odRrSeqrgPR1YP8Sa1_j003CAQhU41OG1Ra9OfHkwVvLTuOrLZAkc5wirElN5nGVCLAOSH5vJhe9A7ycoT0Y1IvoBPzqV_5UzGReRfhDVCgO5Re1pROIHae9lf5cgtsqHdlDoTa_D9v-Kzhwg3ITBUs1AZADsN7epPevBpusG85_BIhAO89i0dPqwBfoT0zCEBJxu_H1oY-YIw9O1cZHcg";

    public final static String VERSION = "5.131";
    static MutableLiveData<Boolean> resultStatusLiveData;
    static MutableLiveData<PlaceholderVK> placeholderVKMutableLiveData;

    public VKDataSource() {

        placeholderVKMutableLiveData = new MutableLiveData<>();
    }

    public static void setStatusVK(String newStatus){
        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        StatusVKAPI statusVKAPI = retrofit.create(StatusVKAPI.class);
        Call<PlaceholderSetStatusVK> call = statusVKAPI.setStatus(ACCESS_TOKEN, newStatus, VERSION);

        call.enqueue(new Callback<PlaceholderSetStatusVK>() {
            @Override
            public void onResponse(Call<PlaceholderSetStatusVK> call, Response<PlaceholderSetStatusVK> response) {
                if(response.isSuccessful()) {
                    Log.i("setStatusVK", response.toString());
                    resultStatusLiveData.setValue(true);
                    return;
                }

                Log.e("ERROR", response.toString());
                resultStatusLiveData.setValue(false);
            }

            @Override
            public void onFailure(Call<PlaceholderSetStatusVK> call, Throwable t) {
                Log.e("setStatusVK", t.toString());
                resultStatusLiveData.setValue(false);
            }
        });
    }
    public static void getStatusVK(){
        Retrofit retrofit = RetrofitFactoryVK.getRetrofit(URL_API);
        StatusVKAPI statusVKAPI = retrofit.create(StatusVKAPI.class);
        Call<PlaceholderVK> call = statusVKAPI.getStatus(ACCESS_TOKEN, VERSION);

        call.enqueue(new Callback<PlaceholderVK>() {
            @Override
            public void onResponse(Call<PlaceholderVK> call, Response<PlaceholderVK> response) {
                if (response.isSuccessful()) {
                    Log.i("Success", response.body().getResponseVK().getText());
                    placeholderVKMutableLiveData.setValue(response.body());

                } else {
                    Log.e("Ей", "Вау!");
                    placeholderVKMutableLiveData.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<PlaceholderVK> call, Throwable t) {
                Log.e("Ей", "Ошибка!!" + t);
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

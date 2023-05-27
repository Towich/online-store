package com.example.firstpractice.ui.ViewModel;

import static com.example.firstpractice.data.sources.VKDataSource.URL_API;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.R;
import com.example.firstpractice.data.api.RetrofitFactory;
import com.example.firstpractice.data.api.RetrofitFactoryVK;
import com.example.firstpractice.data.api.vk.PlaceholderVK;
import com.example.firstpractice.data.api.vk.StatusVKAPI;
import com.example.firstpractice.data.repositories.VKRepository;
import com.example.firstpractice.data.sources.VKDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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

    public void setStatusVK(String newStatus){
        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        StatusVKAPI statusVKAPI = retrofit.create(StatusVKAPI.class);
        Call<PlaceholderVK> call = statusVKAPI.setStatus(newStatus);

        call.enqueue(new Callback<PlaceholderVK>() {
            @Override
            public void onResponse(Call<PlaceholderVK> call, Response<PlaceholderVK> response) {
                if(!response.isSuccessful()) {
                    Log.e("ERROR", response.toString());
                    resultStatus.setValue(true);
                    return;
                }
                resultStatus.setValue(true);
            }

            @Override
            public void onFailure(Call<PlaceholderVK> call, Throwable t) {
                resultStatus.setValue(true);
            }
        });
    }
    public void getStatusVK(){
        Retrofit retrofit = RetrofitFactoryVK.getRetrofit(URL_API);
        StatusVKAPI statusVKAPI = retrofit.create(StatusVKAPI.class);
        Call<PlaceholderVK> call = statusVKAPI.getStatus();

        call.enqueue(new Callback<PlaceholderVK>() {
            @Override
            public void onResponse(Call<PlaceholderVK> call, Response<PlaceholderVK> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", response.body().getResponseVK().getText());
                    statusHolder.setValue(response.body());

                } else {
                    Log.d("Ей", "Вау!");
                    statusHolder.setValue(null);
                    return;
                }
            }
            @Override
            public void onFailure(Call<PlaceholderVK> call, Throwable t) {
                Log.d("Ей", "Ошибка!!" + t.toString());
                statusHolder.setValue(null);
            }
        });
    }
}

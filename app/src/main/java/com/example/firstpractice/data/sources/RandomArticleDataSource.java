package com.example.firstpractice.data.sources;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.data.api.acticles.RetrofitFactory;
import com.example.firstpractice.data.api.acticles.PlaceholderAPI;
import com.example.firstpractice.data.api.acticles.PlaceholderPost;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RandomArticleDataSource {

    public static final String URL_API = "https://jsonplaceholder.typicode.com/";

    private static MutableLiveData<PlaceholderPost> placeholderPost;

    public static MutableLiveData<PlaceholderPost> getPlaceholderPost(){
        placeholderPost = new MutableLiveData<>();
        return placeholderPost;
    }

    public static void getDataFromApi() {
        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        PlaceholderAPI placeholderAPI = retrofit.create(PlaceholderAPI.class);
        Call<List<PlaceholderPost>> call = placeholderAPI.getPosts();
        call.enqueue(new Callback<List<PlaceholderPost>>() {
            @Override
            public void onResponse(Call<List<PlaceholderPost>> call, Response<List<PlaceholderPost>> response) {
                if (response.isSuccessful()) {

                    List<PlaceholderPost> posts = response.body(); // list of all Models

                    if(posts == null){
                        return;
                    }

                    Random random = new Random();
                    PlaceholderPost randomPost = posts.get(random.nextInt(100)); // random one Model

                    Log.d("Success", Integer.toString(randomPost.getUserId()));
                    Log.d("Success", Integer.toString(randomPost.getId()));
                    Log.d("Success", randomPost.getTitle());
                    Log.d("Success", randomPost.getBody());

                    placeholderPost.setValue(randomPost);

                } else {
                    Log.d("Ей", "Вау!");
                }
            }
            @Override
            public void onFailure(Call<List<PlaceholderPost>> call, Throwable t) {
                Log.d("Ей", "Ошибка!!");
            }
        });
    }
}

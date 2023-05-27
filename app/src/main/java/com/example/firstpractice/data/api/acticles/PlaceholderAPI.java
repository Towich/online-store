package com.example.firstpractice.data.api.acticles;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceholderAPI {

    @GET("posts")
    Call<List<PlaceholderPost>> getPosts();

}

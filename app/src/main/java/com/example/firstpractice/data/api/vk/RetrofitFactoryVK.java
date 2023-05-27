package com.example.firstpractice.data.api.vk;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactoryVK {
    private static Retrofit retrofit = null;

    private RetrofitFactoryVK() {} // class should not be initialized

    public static Retrofit getRetrofit(String baseUrl) {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}

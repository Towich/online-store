package com.example.firstpractice.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.firstpractice.data.api.acticles.PlaceholderPost;
import com.example.firstpractice.data.sources.RandomArticleDataSource;

public class RandomArticleRepository {

    private MutableLiveData<PlaceholderPost> placeholderPost;

    public RandomArticleRepository() {
        placeholderPost = RandomArticleDataSource.getPlaceholderPost();
    }

    public void getDataFromApi(){
        RandomArticleDataSource.getDataFromApi();
    }

    public MutableLiveData<PlaceholderPost> getPlaceholderPost(){
        return placeholderPost;
    }
}

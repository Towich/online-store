package com.example.firstpractice.ui.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpractice.data.api.acticles.PlaceholderPost;
import com.example.firstpractice.data.repositories.RandomArticleRepository;

public class RandomArticleViewModel extends AndroidViewModel {
    private final RandomArticleRepository mArticleRepository;

    private MutableLiveData<PlaceholderPost> placeholderPost;

    public RandomArticleViewModel(@NonNull Application application) {
        super(application);
        mArticleRepository = new RandomArticleRepository();
        placeholderPost = mArticleRepository.getPlaceholderPost();
    }

    public MutableLiveData<PlaceholderPost> getPlaceholderPost() {
        return placeholderPost;
    }

    public void getPost(){
        mArticleRepository.getDataFromApi();
    }
}
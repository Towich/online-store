package com.example.firstpractice.ui.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstpractice.R;
import com.example.firstpractice.data.api.acticles.PlaceholderAPI;
import com.example.firstpractice.data.api.acticles.PlaceholderPost;
import com.example.firstpractice.data.api.RetrofitFactory;
import com.example.firstpractice.ui.ViewModel.RandomArticleViewModel;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RandomArticle extends Fragment {


    private RandomArticleViewModel mViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_random_article, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(RandomArticleViewModel.class);

        TextView text_view_user_id = view.findViewById(R.id.text_view_user_id);
        TextView text_view_article_id = view.findViewById(R.id.text_view_article_id);
        TextView text_view_title = view.findViewById(R.id.text_view_title);
        TextView text_view_body = view.findViewById(R.id.text_view_body);

        mViewModel.getPlaceholderPost().observe(getViewLifecycleOwner(), observer -> {
            text_view_user_id.setText("ID user: " + observer.getUserId());
            text_view_article_id.setText("ID article: " + observer.getId());
            text_view_title.setText("TITLE: " + observer.getTitle());
            text_view_body.setText(observer.getBody());
        });

        mViewModel.getPost();
    }


}
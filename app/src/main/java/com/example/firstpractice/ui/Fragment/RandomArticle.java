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

    public final String URL_API =
            "https://jsonplaceholder.typicode.com/";
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

        getDataFromApi(view);
    }

    private void getDataFromApi(View view) {
        TextView text_view_user_id = view.findViewById(R.id.text_view_user_id);
        TextView text_view_article_id = view.findViewById(R.id.text_view_article_id);
        TextView text_view_title = view.findViewById(R.id.text_view_title);
        TextView text_view_body = view.findViewById(R.id.text_view_body);

        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        PlaceholderAPI placeholderAPI = retrofit.create(PlaceholderAPI.class);
        Call<List<PlaceholderPost>> call = placeholderAPI.getPosts();
        call.enqueue(new Callback<List<PlaceholderPost>>() {
            @Override
            public void onResponse(Call<List<PlaceholderPost>> call, Response<List<PlaceholderPost>> response) {
                if (response.isSuccessful()) {

                    List<PlaceholderPost> posts = response.body(); // list of all Models

                    Random random = new Random();
                    PlaceholderPost randomPost = posts.get(random.nextInt(100)); // random one Model

                    Log.d("Success", Integer.toString(randomPost.getUserId()));
                    Log.d("Success", Integer.toString(randomPost.getId()));
                    Log.d("Success", randomPost.getTitle());
                    Log.d("Success", randomPost.getBody());

                    text_view_user_id.setText("ID user: " + Integer.toString(randomPost.getUserId()));
                    text_view_article_id.setText("ID article: " + Integer.toString(randomPost.getId()));
                    text_view_title.setText("TITLE: " + randomPost.getTitle());
                    text_view_body.setText(randomPost.getBody());

                } else {
                    Log.d("Ей", "Вау!");
                    return;
                }
            }
            @Override
            public void onFailure(Call<List<PlaceholderPost>> call, Throwable t) {
                Log.d("Ей", "Ошибка!!");
            }
        });
    }
}
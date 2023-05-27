package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firstpractice.R;
import com.example.firstpractice.data.api.RetrofitFactory;
import com.example.firstpractice.data.api.RetrofitFactoryVK;
import com.example.firstpractice.data.api.vk.PlaceholderVK;
import com.example.firstpractice.data.api.vk.ResponseVK;
import com.example.firstpractice.data.api.vk.StatusVKAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class VKFragment extends Fragment {

    Button button_change_status_vk;
    TextView text_view_current_status_vk;

    private final static String URL_API = "https://api.vk.com/method/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_v_k, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText edit_text_status_vk = view.findViewById(R.id.edit_text_status_vk);
        text_view_current_status_vk = view.findViewById(R.id.text_view_current_status_vk);

        getDataFromAPI();
        //setDataToAPI("С любовью из тильта <3");

        button_change_status_vk = view.findViewById(R.id.button_change_status_vk);
        button_change_status_vk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataToAPI(edit_text_status_vk.getText().toString());
            }
        });
    }

    private void getDataFromAPI(){
        Retrofit retrofit = RetrofitFactoryVK.getRetrofit(URL_API);
        StatusVKAPI statusVKAPI = retrofit.create(StatusVKAPI.class);
        Call<PlaceholderVK> call = statusVKAPI.getStatus();

        call.enqueue(new Callback<PlaceholderVK>() {
            @Override
            public void onResponse(Call<PlaceholderVK> call, Response<PlaceholderVK> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", response.body().getResponseVK().getText());
                    text_view_current_status_vk.setText("Текущий статус:\n" + response.body().getResponseVK().getText());

                } else {
                    Log.d("Ей", "Вау!");
                    return;
                }
            }
            @Override
            public void onFailure(Call<PlaceholderVK> call, Throwable t) {
                Log.d("Ей", "Ошибка!!" + t.toString());

            }
        });
    }
    private void setDataToAPI(String newStatus){

        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        StatusVKAPI statusVKAPI = retrofit.create(StatusVKAPI.class);
        Call<PlaceholderVK> call = statusVKAPI.setStatus(newStatus);

        call.enqueue(new Callback<PlaceholderVK>() {
            @Override
            public void onResponse(Call<PlaceholderVK> call, Response<PlaceholderVK> response) {
                if(!response.isSuccessful()) {
                    Log.e("ERROR", response.toString());
                    button_change_status_vk.setText("ERROR!");
                    button_change_status_vk.setTextColor(getResources().getColor(R.color.red));
                    return;
                }
                button_change_status_vk.setText("Successful!");
                button_change_status_vk.setTextColor(getResources().getColor(R.color.green));
                getDataFromAPI();
            }

            @Override
            public void onFailure(Call<PlaceholderVK> call, Throwable t) {

//                TODO
//                Log.e("ERROR", t.toString());
//                button_change_status_vk.setText("ERROR!");
//                button_change_status_vk.setTextColor(getResources().getColor(R.color.red));

                button_change_status_vk.setText("Successful!");
                button_change_status_vk.setTextColor(getResources().getColor(R.color.green));
                getDataFromAPI();
            }
        });

    }
}
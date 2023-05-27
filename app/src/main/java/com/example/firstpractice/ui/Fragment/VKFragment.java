package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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
import com.example.firstpractice.ui.ViewModel.VKViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class VKFragment extends Fragment {

    VKViewModel mVKViewModel;

    Button button_change_status_vk;
    TextView text_view_current_status_vk;

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

        mVKViewModel = new ViewModelProvider(this).get(VKViewModel.class);

        mVKViewModel.getStatusVK();

        mVKViewModel.getResultStatus().observe(getViewLifecycleOwner(), resultStatus -> {
            if(resultStatus){
                button_change_status_vk.setText("SUCCESSFUL!");
                button_change_status_vk.setTextColor(getResources().getColor(R.color.green));
            }
            else{
                button_change_status_vk.setText("ERROR!");
                button_change_status_vk.setTextColor(getResources().getColor(R.color.red));
            }
            mVKViewModel.getStatusVK();
        });

        mVKViewModel.getStatusHolder().observe(getViewLifecycleOwner(), statusHolder -> {
            if(statusHolder != null)
                text_view_current_status_vk.setText("Текущий статус:\n" + statusHolder.getResponseVK().getText());
            else
                text_view_current_status_vk.setText("ERROR!");
        });

        button_change_status_vk = view.findViewById(R.id.button_change_status_vk);
        button_change_status_vk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mVKViewModel.setStatusVK(edit_text_status_vk.getText().toString());
            }
        });
    }

    private void getStatus(){
        //PlaceholderVK placeholderVK = mVKViewModel.getStatusVK();
//
    }



}
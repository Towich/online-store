package com.example.firstpractice.ui;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstpractice.R;
import com.example.firstpractice.domain.LuckyPerfumeViewModel;

public class IAmLuckyFragment extends Fragment {

    LuckyPerfumeViewModel model;

    private Button bttnLuckyPerfume;
    private ImageView imagePerfume;
    private TextView textPerfume;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_i_am_lucky, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // Searching elements
        bttnLuckyPerfume = view.findViewById(R.id.buttonGetLuckyPerfume);
        imagePerfume = view.findViewById(R.id.imageViewLuckyPerfume);
        textPerfume = view.findViewById(R.id.text_rolled_perfume);

        // Connecting to ViewModel
        model = new ViewModelProvider(this).get(LuckyPerfumeViewModel.class);
        model.getLuckyPerfume().observe(getViewLifecycleOwner(), luckyPerfume -> {
            imagePerfume.setImageResource(luckyPerfume.getImagePerfume());
            textPerfume.setText(luckyPerfume.getNamePerfume());
        });

        bttnLuckyPerfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.rollLuckyPerfume();
                Log.i("IAmLucky", "ROLLED!");
            }
        });
    }
}
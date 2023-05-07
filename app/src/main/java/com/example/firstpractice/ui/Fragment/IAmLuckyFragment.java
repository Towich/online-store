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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstpractice.R;
import com.example.firstpractice.ui.ViewModel.LuckyPerfumeViewModel;

public class IAmLuckyFragment extends Fragment {

    LuckyPerfumeViewModel model;        // ViewModel

    private Button bttnLuckyPerfume;    // Button "I am lucky!"
    private ImageView imagePerfume;     // Image of Lucky Perfume
    private TextView textPerfume;       // Text of Lucky Perfume

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

        // Connecting to ViewModel and subscribe for updates of luckyPerfume
        model = new ViewModelProvider(this).get(LuckyPerfumeViewModel.class);
        model.luckyPerfume.observe(getViewLifecycleOwner(), luckyPerfume -> {
            // Change Image&Text of Lucky Perfume
            imagePerfume.setImageResource(model.getPerfume().getImagePerfume());
            textPerfume.setText(model.getPerfume().getNamePerfume());
        });

        // Adding listener to button "I am lucky!"
        bttnLuckyPerfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.rollLuckyPerfume();
                Log.i("IAmLucky", "Rolled perfume: "+ model.getPerfume().getNamePerfume());
            }
        });
    }
}
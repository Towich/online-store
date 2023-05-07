package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.firstpractice.R;
import com.example.firstpractice.ui.ViewModel.ShopsViewModel;


public class ShopsFragment extends Fragment {

    ShopsViewModel model;   // ViewModel

    private ImageView image_first_shop; // ImageView of First Shop
    private TextView text_first_shop;   // TextView of First Shop

    private ImageView image_second_shop;// ImageView of Second Shop
    private TextView text_second_shop;  // TextView of Second Shop

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shops, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Searching elements
        image_first_shop = view.findViewById(R.id.image_view_first_shop);
        text_first_shop = view.findViewById(R.id.text_view_first_shop);
        image_second_shop = view.findViewById(R.id.image_view_second_shop);
        text_second_shop = view.findViewById(R.id.text_view_second_shop);

        // Connecting to ViewModel
        model = new ViewModelProvider(this).get(ShopsViewModel.class);
        model.shops.observe(getViewLifecycleOwner(), shops -> {
            image_first_shop.setImageResource(model.getIdDrawable(0));
            text_first_shop.setText(model.getName(0));

            image_second_shop.setImageResource(model.getIdDrawable(1));
            text_second_shop.setText(model.getName(1));
        });
    }
}
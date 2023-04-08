package com.example.firstpractice.ui;

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
import com.example.firstpractice.domain.LuckyPerfumeViewModel;
import com.example.firstpractice.domain.ShopsViewModel;


public class ShopsFragment extends Fragment {

    ShopsViewModel model;

    private ImageView image_first_shop;
    private TextView text_first_shop;

    private ImageView image_second_shop;
    private TextView text_second_shop;

    private Button button_load_our_shops;

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
        button_load_our_shops = view.findViewById(R.id.button_load_our_shops);

        // Connecting to ViewModel
        model = new ViewModelProvider(this).get(ShopsViewModel.class);
        model.getShopRepository().observe(getViewLifecycleOwner(), shopRepository -> {
            image_first_shop.setImageResource(shopRepository.getFirstShop().getIdDrawableImage());
            text_first_shop.setText(shopRepository.getFirstShop().getName());

            image_second_shop.setImageResource(shopRepository.getSecondShop().getIdDrawableImage());
            text_second_shop.setText(shopRepository.getSecondShop().getName());
        });

        // Adding listener to button
        button_load_our_shops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.createShops();
                Log.i("Shop", "Created!");
            }
        });
    }
}
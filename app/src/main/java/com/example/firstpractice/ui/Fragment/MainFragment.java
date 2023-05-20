package com.example.firstpractice.ui.Fragment;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.firstpractice.R;


public class MainFragment extends Fragment {

    ImageButton user_image_view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // *Buttons*

        user_image_view = view.findViewById(R.id.user_image_view);

        StartAnimLogo();
        user_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartAnimLogo();
            }
        });


        // button "Store"
        Button btn_store = view.findViewById(R.id.button_store);
        btn_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_storeFragment2);
            }
        });

        // button "I am lucky!"
        Button btn_i_am_lucky = view.findViewById(R.id.button_i_am_lucky);
        btn_i_am_lucky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_IAmLuckyFragment);
            }
        });

        // button "Check our shops"
        Button btn_our_shops = view.findViewById(R.id.button_our_shops);
        btn_our_shops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_shopsFragment);
            }
        });

        // button "Databases"
        Button btn_databases = view.findViewById(R.id.button_databases);
        btn_databases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_databaseFragment);
            }
        });

        // button "Contacts"
        Button btn_contacts = view.findViewById(R.id.button_store_contacts);
        btn_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_contactsFragment);
            }
        });
    }

    private void StartAnimLogo(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) user_image_view.getDrawable();
            drawable.start();
        }
    }


}
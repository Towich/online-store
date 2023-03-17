package com.example.firstpractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class ContentFragment extends Fragment {

    private int perfumeCounter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getContext(), "onCreateContentFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onCreateContentFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onViewCreated");

        ImageButton btn_cart = view.findViewById(R.id.button_lets_shop);
        Button btnAddToCart = view.findViewById(R.id.button_add_perfume);

        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new SecondFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container_view, newFragment);
                transaction.commit();
                Log.i("Fragment", "onClick");
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perfumeCounter++;
                Log.i("Fragment", "Total perfume: " + perfumeCounter);
            }
        });
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();

        Toast.makeText(getContext(), "onStart", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();

        Toast.makeText(getContext(), "onResume", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();

        Toast.makeText(getContext(), "onPause", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();

        Toast.makeText(getContext(), "onStop", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onSaveInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onDestroy");
    }
}
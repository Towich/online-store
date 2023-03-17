package com.example.firstpractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.firstpractice.databinding.FragmentMainBinding;


public class ContentFragment extends Fragment {

    private int perfumeCounter;
    FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Fragment", "onCreateContentFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i("Fragment", "onCreateView");
        // Inflate the layout for this fragment

        fragmentManager = getParentFragmentManager();

        fragmentManager.setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                int receivedPerfumeCounter = result.getInt("perfumeCounter");
                perfumeCounter = receivedPerfumeCounter;
            }
        });

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("Fragment", "onViewCreated");


        ImageButton btn_cart = view.findViewById(R.id.button_lets_shop);

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

        Button btn_store = view.findViewById(R.id.button_store);
        Button btn_store_discounts = view.findViewById(R.id.button_store_discounts);

        btn_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_view, new StoreFragment());
                fragmentTransaction.commit();
            }
        });

        btn_store_discounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_view, new StoreDiscountsFragment());
                fragmentTransaction.commit();
            }
        });
    }



    @Override
    public void onStop() {
        super.onStop();

        Bundle result = new Bundle();
        result.putInt("perfumeCounter", perfumeCounter);
        fragmentManager.setFragmentResult("requestKey", result);
    }

}
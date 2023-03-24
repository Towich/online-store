package com.example.firstpractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.os.Debug;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.firstpractice.databinding.FragmentMainBinding;
import com.google.android.material.textfield.TextInputEditText;


public class ContentFragment extends Fragment {

    private int perfumeCounter;
    private int perfumeToWatch;
    FragmentManager fragmentManager;
    TextInputEditText perfumeToWatchText;

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

        // ResultListener for receiving perfume counter from Fragment "Cart"
        // %outdated%
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

        perfumeToWatch = 10;
        perfumeToWatchText = view.findViewById(R.id.input_text_perfumes);

        // *Buttons*

        // button "Cart"
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

        // button "Store"
        Button btn_store = view.findViewById(R.id.button_store);
        btn_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perfumeToWatch = Integer.parseInt(perfumeToWatchText.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putInt("perfume_to_watch", perfumeToWatch);
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_storeFragment2, bundle);
            }
        });

        // button "Discounts"
        Button btn_store_discounts = view.findViewById(R.id.button_store_discounts);
        btn_store_discounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perfumeToWatch = Integer.parseInt(perfumeToWatchText.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putInt("perfume_to_watch", perfumeToWatch);

                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_storeDiscountsFragment2, bundle);
            }
        });

        // button "Info"
        ImageButton btn_info = view.findViewById(R.id.button_info);
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                    Here we have to make a notification
                 */

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
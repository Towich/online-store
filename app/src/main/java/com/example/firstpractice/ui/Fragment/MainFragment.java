package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.firstpractice.R;


public class MainFragment extends Fragment {

    int currentValue = 0;

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

        ProgressBar indicatorBar = view.findViewById(R.id.indicator);
        TextView statusView = view.findViewById(R.id.statusView);
        Button btnFetch = view.findViewById(R.id.progressBtn);

        btnFetch.setOnClickListener(view1 -> {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for(; currentValue <= 100; currentValue++){
                        try{
                            statusView.post(new Runnable() {
                                @Override
                                public void run() {
                                    indicatorBar.setProgress(currentValue);
                                }
                            });

                            Thread.sleep(400);
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
        });
    }
}
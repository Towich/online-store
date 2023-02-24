package com.example.firstpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.firstpractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApplication";

    ActivityMainBinding binding;
    Intent intent;
    Context context;
    int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = getApplicationContext();
        duration = Toast.LENGTH_SHORT;
        intent = new Intent(this, SecondActivity.class);


        Button button_lets_shop = binding.buttonLetsShop;
        button_lets_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "opening secondActivity");
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(context, "toast onStart", duration).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(context, "toast onStop", duration).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(context, "toast onDestroy", duration).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(context, "toast onPause", duration).show();

    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(context, "toast onResume", duration).show();
    }
}
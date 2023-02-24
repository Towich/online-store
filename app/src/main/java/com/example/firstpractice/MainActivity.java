package com.example.firstpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.firstpractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApplication";

    Context context;
    int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = getApplicationContext();
        duration = Toast.LENGTH_SHORT;

        Log.d(TAG, "%Debug% in onCreate");

        Button button_lets_shop = binding.buttonLetsShop;
        button_lets_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Clicked!");
            }
        });

        button_lets_shop.setText("Let's shopping!");

        ImageView shop_logo = binding.userImageView;
        shop_logo.setImageResource(R.drawable.logo_image);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast toast = Toast.makeText(context, "toast onStart", duration);
        toast.show();

        Log.i(TAG, "%Info% in onStart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(context, "toast onStop", duration);
        toast.show();

        Log.w(TAG,"%Warning% in onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast toast = Toast.makeText(context, "toast onDestroy", duration);
        toast.show();

        Log.e(TAG, "%ERROR% in onDestroy");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast toast = Toast.makeText(context, "toast onPause", duration);
        toast.show();

        Log.v(TAG, "%More info% in onPause");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast toast = Toast.makeText(context, "toast onResume", duration);
        toast.show();
    }
}
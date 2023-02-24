package com.example.firstpractice;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.firstpractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApplication";

    ActivityMainBinding binding;
    Intent intent;
    Context context;
    int duration;
    int totalPerfume = 0;

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent1 = result.getData();
                    Bundle arguments = intent1.getExtras();
                    totalPerfume = (int)arguments.get("total_perfume");
                    Log.i(TAG, "Received from SecondActivity!");
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = getApplicationContext();
        duration = Toast.LENGTH_SHORT;
        intent = new Intent(this, SecondActivity.class);


        ImageButton button_lets_shop = binding.buttonLetsShop;
        button_lets_shop.setOnClickListener(view -> {
            Log.i(TAG, "opening secondActivity");
            intent.putExtra("total_perfume", totalPerfume);
            mStartForResult.launch(intent);
        });

        binding.buttonAddPerfume.setOnClickListener(view -> {
            totalPerfume++;
            Toast.makeText(context, "Total perfume: " + totalPerfume, duration).show();
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onPause() {
        super.onPause();

    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
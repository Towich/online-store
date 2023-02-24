package com.example.firstpractice;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstpractice.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;
    Intent intent;
    int totalPerfume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent = new Intent(this, MainActivity.class);

        Bundle arguments = getIntent().getExtras();
        totalPerfume = (int)arguments.get("total_perfume");
        String newStr = "Total perfume: " + totalPerfume;

        binding.totalPerfumeText.setText(newStr);


        binding.buttonExit.setOnClickListener(view -> {
            Intent intent1 = new Intent();
            intent1.putExtra("total_perfume", totalPerfume);
            setResult(1, intent1);
            finish();
        });
    }


}
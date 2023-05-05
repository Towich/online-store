package com.example.firstpractice.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstpractice.R;

public class ExternalDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_data);

        // Get the intent that started this activity
        Intent intent = getIntent();

        if (intent.getType().equals("text/plain")) {
            String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView text_view_external_data = findViewById(R.id.text_view_external_data);
            text_view_external_data.setText(sharedText);
        }
    }

}
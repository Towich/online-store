package com.example.firstpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApplication";


    Context context;
    int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        duration = Toast.LENGTH_SHORT;

        Log.d(TAG, "%Debug% in onCreate");

        Button button_lets_shop = findViewById(R.id.button_lets_shop);
        button_lets_shop.setText("Let's shopping!");
        button_lets_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "CLICKED!", duration).show();

                Log.i(TAG, "CLICKED!");
            }
        });

        ImageView shop_logo = findViewById(R.id.user_image_view);
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
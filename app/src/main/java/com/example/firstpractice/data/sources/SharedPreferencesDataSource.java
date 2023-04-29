package com.example.firstpractice.data.sources;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SharedPreferencesDataSource {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private final String saveKey = "save_key";

    public void create(Context context){
        sharedPreferences = context.getSharedPreferences("Test", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    // #3 SharedPreferences (save and load)
    public void save(String toSave){
        editor.putString(saveKey, toSave);
        editor.apply();
    }

    public String load(){
        return sharedPreferences.getString(saveKey, "null");
    }

}

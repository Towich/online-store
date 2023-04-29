package com.example.firstpractice.data.resources;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Debug;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DatabasesDataSource extends AppCompatActivity {
    private File saveFile1;
    private File saveFile2;

    private Scanner scan;

    private String file1;
    private String file2;

    private Context context;

    public DatabasesDataSource(){
        file1 = "file1.txt";
        file2 = "file2.txt";
    }

    // #1 App-specific storage (create, save and load)

    public void createFileAppSpecific(Context context){
        saveFile1 = new File(context.getFilesDir(), file1);
        Log.i(file1, context.getFilesDir().toString());
        this.context = context;
    }
    public void saveAppSpecific(String toSave){
        try{
            FileWriter fileWriter = new FileWriter(saveFile1, false);
            fileWriter.write(toSave);
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e){
            Log.e(getClass().toString(), "ERROR: Can't write in file '" + saveFile1.getName() + "'!");
        }
    }
    public String loadAppSpecific(){
        StringBuilder result = new StringBuilder();

        try{
            FileReader fileReader = new FileReader(saveFile1);
            scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                result.append(scan.nextLine());
            }
            fileReader.close();
        }
        catch (IOException e){
            Log.e(getClass().toString(), "ERROR: Can't read file '" + file1 + "'!");
        }

        return result.toString();
    }

    // #2 SharedStorage (create, save and load)

    public void createFileSharedStorage(Context context){
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            Log.i(file2, Environment.getExternalStorageDirectory().toString());
            saveFile2 = new File(Environment.getExternalStorageDirectory(), file2);
        }
        else {
            Log.e(getClass().toString(),"NO PERMISSION!");
        }


    }
    public void saveSharedStorage(String toSave){
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            try {
                FileWriter writer = new FileWriter(saveFile2);
                writer.write(toSave);
                writer.close();
            } catch (IOException e) {
                Log.e(getClass().toString(), "ERROR: Can't write in file '" + file2 + "': " + e.toString());
            }
        }
        else {
            Log.e(getClass().toString(),"NO PERMISSION!");
        }
    }
    public String loadSharedStorage(){
        StringBuilder result = new StringBuilder();

        try{
            FileReader fileReader = new FileReader(saveFile2);
            scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                result.append(scan.nextLine());
            }
            fileReader.close();
        }
        catch (IOException e){
            Log.e(getClass().toString(), "ERROR: Can't read file '" + file2 + "': " + e.toString());
        }

        return result.toString();
    }
}

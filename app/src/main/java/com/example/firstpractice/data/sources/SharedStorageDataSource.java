package com.example.firstpractice.data.sources;

import android.Manifest;
import android.content.Context;
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

public class SharedStorageDataSource {
    private File saveFile;
    private Scanner scan;
    private final String fileName;

    public SharedStorageDataSource(){
        fileName = "file2.txt";
    }

    // #2 SharedStorage (create, save and load)
    public void createFile(Context context){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            Log.i(fileName, Environment.getExternalStorageDirectory().toString());
            saveFile = new File(Environment.getExternalStorageDirectory(), fileName);
        }
        else {
            Log.e(getClass().toString(),"NO PERMISSION!");
        }


    }
    public void save(String toSave) {
        try {
            FileWriter writer = new FileWriter(saveFile);
            writer.write(toSave);
            writer.close();
        } catch (IOException e) {
            Log.e(getClass().toString(), "ERROR: Can't write in file '" + fileName + "': " + e.toString());
        }
    }

    public String load(){
        StringBuilder result = new StringBuilder();

        try{
            FileReader fileReader = new FileReader(saveFile);
            scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                result.append(scan.nextLine());
            }
            fileReader.close();
        }
        catch (IOException e){
            Log.e(getClass().toString(), "ERROR: Can't read file '" + fileName + "': " + e.toString());
        }

        return result.toString();
    }
}

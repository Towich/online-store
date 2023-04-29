package com.example.firstpractice.data.sources;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppSpecificDataSource extends AppCompatActivity {
    private File saveFile;
    private Scanner scan;
    private final String fileName;
    private Context context;

    public AppSpecificDataSource(){
        fileName = "file1.txt";
    }

    // #1 App-specific storage (create, save and load)
    public void createFile(Context context){
        saveFile = new File(context.getFilesDir(), fileName);
        Log.i(fileName, context.getFilesDir().toString());
        this.context = context;
    }
    public void save(String toSave){
        try{
            FileWriter fileWriter = new FileWriter(saveFile, false);
            fileWriter.write(toSave);
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e){
            Log.e(getClass().toString(), "ERROR: Can't write in file '" + saveFile.getName() + "'!");
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
            Log.e(getClass().toString(), "ERROR: Can't read file '" + fileName + "'!");
        }

        return result.toString();
    }
}

package com.example.firstpractice.data.resources;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppSpecificModel extends AppCompatActivity {
    private File saveFile;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private Scanner scan;

    public AppSpecificModel(){

    }

    public void createFile(Context context){
        saveFile = new File(context.getFilesDir(), "file1.txt");
        Log.i("File", context.getFilesDir().toString());

//        try{
//        }
//        catch(IOException ex){
//            Log.e(getClass().toString(), "ERROR: Can't create FileWriter/FileReader!");
//        }
    }

    public void save(String toSave){
        try{
            fileWriter = new FileWriter(saveFile, false);
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
            fileReader = new FileReader(saveFile);
            scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                result.append(scan.nextLine());
            }
            fileReader.close();
        }
        catch (IOException e){
            Log.e(getClass().toString(), "ERROR: Can't write in file '" + saveFile.getName() + "'!");
        }

        return result.toString();
    }
}

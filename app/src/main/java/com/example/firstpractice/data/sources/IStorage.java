package com.example.firstpractice.data.sources;

import android.content.Context;

public interface IStorage {
    void createFile(Context context);   // Create storage file
    void save(String toSave);           // Save String in storage file
    String load();                      // Load String from a storage file
}

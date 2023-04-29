package com.example.firstpractice.ui.Fragment;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.firstpractice.R;
import com.example.firstpractice.ui.ViewModel.DatabasesViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;


public class DatabasesFragment extends Fragment {

    DatabasesViewModel model;
    TextView textSavedTextView;
    TextInputEditText textToSaveTextInput;

    Button buttonSaveAppSpecificStorage;
    Button buttonLoadAppSpecificStorage;

    Button buttonSaveSharedStorage;
    Button buttonLoadSharedStorage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_databases, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        InitViews(view);

        model = new ViewModelProvider(this).get(DatabasesViewModel.class);

        CreateAppSpecific();
        CreateSharedStorage();
    }

    private void InitViews(View view){
        textSavedTextView = view.findViewById(R.id.textSavedString);
        textToSaveTextInput = view.findViewById(R.id.inputTextToSave);

        buttonSaveAppSpecificStorage = view.findViewById(R.id.buttonSaveAppSpecificStorage);
        buttonSaveAppSpecificStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.saveDataAppSpecific(textToSaveTextInput.getText().toString());
            }
        });

        buttonLoadAppSpecificStorage = view.findViewById(R.id.buttonLoadAppSpecificStorage);
        buttonLoadAppSpecificStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textSavedTextView.setText(model.loadDataAppSpecific());
            }
        });

        buttonSaveSharedStorage = view.findViewById(R.id.buttonSaveCommonStorage);
        buttonSaveSharedStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.saveSharedStorage(textToSaveTextInput.getText().toString());
            }
        });

        buttonLoadSharedStorage = view.findViewById(R.id.buttonLoadCommonStorage);
        buttonLoadSharedStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textSavedTextView.setText(model.loadSharedStorage());
            }
        });
    }

    private void CreateAppSpecific(){

        // #1 | Create App-Specific file
        model.createAppSpecific(getActivity().getApplicationContext());
    }

    private void CreateSharedStorage(){

        // #2 | Gain permission for writing files in storage
        if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]
                    {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        // #2 | Create SharedStorage file
        model.createSharedStorage(getActivity().getApplicationContext());

        // #2 | Check if we can write in storage
        Log.d("can write", String.valueOf(Environment.getExternalStorageDirectory().canWrite()));
    }
}
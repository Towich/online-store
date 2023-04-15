package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.firstpractice.R;
import com.example.firstpractice.ui.ViewModel.DatabasesViewModel;
import com.google.android.material.textfield.TextInputEditText;


public class DatabasesFragment extends Fragment {

    DatabasesViewModel model;
    TextView textSavedTextView;
    TextInputEditText textToSaveTextInput;

    Button buttonSaveAppSpecificStorage;
    Button buttonLoadAppSpecificStorage;

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
        ConnectToViewModel();
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
    }

    private void ConnectToViewModel(){
        // Connecting to ViewModel
        model = new ViewModelProvider(this).get(DatabasesViewModel.class);
        model.getAppSpecific().observe(getViewLifecycleOwner(), saveFile -> {
            // something doing when the saveFile is updated
        });
        model.createAppSpecific(getActivity().getApplicationContext());
    }


}
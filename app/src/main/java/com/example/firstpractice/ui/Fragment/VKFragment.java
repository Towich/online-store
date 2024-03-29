package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firstpractice.R;
import com.example.firstpractice.ui.ViewModel.VKViewModel;


public class VKFragment extends Fragment {

    VKViewModel mVKViewModel;

    TextView text_view_current_status_vk;
    EditText edit_text_status_vk;
    Button button_change_status_vk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_v_k, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edit_text_status_vk = view.findViewById(R.id.edit_text_status_vk);
        text_view_current_status_vk = view.findViewById(R.id.text_view_current_status_vk);

        mVKViewModel = new ViewModelProvider(this).get(VKViewModel.class);

        // Run @getStatus
        mVKViewModel.getStatusVK();

        // Result of @setStatus
        mVKViewModel.getResultStatus().observe(getViewLifecycleOwner(), resultStatus -> {

            button_change_status_vk.setText(resultStatus ? "SUCCESSFUL!" : "ERROR!");
            button_change_status_vk.setTextColor(getResources().getColor(resultStatus ? R.color.green : R.color.red));

            mVKViewModel.getStatusVK();
        });

        // Result of @getStatus
        mVKViewModel.getStatusHolder().observe(getViewLifecycleOwner(), statusHolder -> {
            text_view_current_status_vk.setText(statusHolder != null ?
                    "Текущий статус:\n" + mVKViewModel.getStringStatusVK() : "ERROR!");

        });

        // Button "ИЗМЕНИТЬ СТАТУС"
        button_change_status_vk = view.findViewById(R.id.button_change_status_vk);
        button_change_status_vk.setOnClickListener(view1 ->
                mVKViewModel.setStatusVK(edit_text_status_vk.getText().toString()));

        edit_text_status_vk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                button_change_status_vk.setText("ИЗМЕНИТЬ СТАТУС");
                button_change_status_vk.setTextColor(getResources().getColor(R.color.white));
            }
        });
    }
}
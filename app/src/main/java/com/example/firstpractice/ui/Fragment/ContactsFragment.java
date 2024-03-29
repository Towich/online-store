package com.example.firstpractice.ui.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.firstpractice.R;
import com.example.firstpractice.data.sources.ContactsDataSource;
import com.example.firstpractice.ui.ViewModel.ContactsViewModel;


public class ContactsFragment extends Fragment {

    private ContactsViewModel mContactsViewModel;   // ViewModel

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize ViewModel
        mContactsViewModel = new ViewModelProvider(this).get(ContactsViewModel.class);

        // *Buttons*

        // Button "Make a call"
        Button button_made_call = view.findViewById(R.id.button_made_call);
        button_made_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start Intent with "Phone Number"
                startActivity(mContactsViewModel.getIntentMakeCall());
            }
        });

        // Button "Send email"
        Button button_send_email = view.findViewById(R.id.button_send_email);
        button_send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start Intent with "Email"
                startActivity(mContactsViewModel.getIntentSendEmail());
            }
        });

    }
}
package com.example.firstpractice.ui.ViewModel;

import static java.net.Proxy.Type.HTTP;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.firstpractice.data.sources.ContactsDataSource;

public class ContactsViewModel extends AndroidViewModel {
    public ContactsViewModel(@NonNull Application application) {
        super(application);
    }

    // Create Intent with "Phone Number"
    public Intent getIntentMakeCall(){
        Uri number = Uri.parse("tel:" + ContactsDataSource.PHONE_NUMBER);
        return new Intent(Intent.ACTION_DIAL, number);
    }

    // Create Intent with "E-mail"
    public Intent getIntentSendEmail(){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        // The intent does not have a URI, so declare the "text/plain" MIME type
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {ContactsDataSource.EMAIL}); // email recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Идеи/предложения");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Добрый день! У меня есть следующее предложение:");

        return emailIntent;
    }
}

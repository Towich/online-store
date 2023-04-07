package com.example.firstpractice;

import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public interface MainContract {

    // UI Layer
    interface View {
        List<String> showItems(int quantity);
        FragmentActivity getFragmentActivity();
    }

    // Domain Layer
    interface Delegate {
        List<String> onViewCreatedForDelegate(int quantity);
    }

    // Data Layer
    interface Repository {
        List<String> CreateListOfItems(int quantity);
    }
}

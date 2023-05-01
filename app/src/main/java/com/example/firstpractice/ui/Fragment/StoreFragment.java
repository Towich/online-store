package com.example.firstpractice.ui.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firstpractice.R;
import com.example.firstpractice.ui.Adapter.MyCustomRecyclerViewAdapter;
import com.example.firstpractice.ui.Presenter.StorePresenter;
import com.example.firstpractice.ui.ViewModel.CommonPerfumeViewModel;

import java.util.List;


public class StoreFragment extends Fragment{

    private CommonPerfumeViewModel mCommonPerfumeViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_store);
        final MyCustomRecyclerViewAdapter adapter = new MyCustomRecyclerViewAdapter(new MyCustomRecyclerViewAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mCommonPerfumeViewModel = new ViewModelProvider(this).get(CommonPerfumeViewModel.class);

        mCommonPerfumeViewModel.getAllCommonPerfumes().observe(getActivity(), words -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(words);
        });
    }
}
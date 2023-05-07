package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstpractice.R;
import com.example.firstpractice.data.databases.entity.CommonPerfumeEntity;
import com.example.firstpractice.ui.Adapter.MyCustomRecyclerViewAdapter;
import com.example.firstpractice.ui.ViewModel.CommonPerfumeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class StoreFragment extends Fragment{

    private CommonPerfumeViewModel mCommonPerfumeViewModel; // ViewModel

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get result from NewPerfumeFragment
        getParentFragmentManager().setFragmentResultListener(NewPerfumeFragment.REPLY_PERFUME,
                this, (key, bundle) -> {

                    // Get name & price of new Perfume from NewPerfumeFragment
                    String namePerfume = bundle.getString(NewPerfumeFragment.REPLY_NAME);
                    int pricePerfume = bundle.getInt(NewPerfumeFragment.REPLY_PRICE);

                    // Create new Entity and insert in Database
                    CommonPerfumeEntity perfumeEntity = new CommonPerfumeEntity(namePerfume, pricePerfume);
                    mCommonPerfumeViewModel.insert(perfumeEntity);
                });
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

        // RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_store);
        final MyCustomRecyclerViewAdapter adapter = new MyCustomRecyclerViewAdapter(new MyCustomRecyclerViewAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // FloatingActionButton
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(view1 -> {
            // Navigate to NewPerfumeFragment
            Navigation.findNavController(view1).navigate(R.id.action_storeFragment_to_newPerfumeFragment);
        });

        // Initialize ViewModel
        mCommonPerfumeViewModel = new ViewModelProvider(this).get(CommonPerfumeViewModel.class);

        // Subscribe for updates of table "common_perfume_table" in Database
        // Update the cached copy of the words in the adapter.
        mCommonPerfumeViewModel.getAllCommonPerfumes().observe(getActivity(), adapter::submitList);
    }
}
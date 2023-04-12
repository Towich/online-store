package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstpractice.MainContract;
import com.example.firstpractice.ui.Adapter.MyCustomRecyclerViewAdapter;
import com.example.firstpractice.R;
import com.example.firstpractice.ui.ViewModel.FirstDelegate;

import java.util.List;


public class StoreDiscountsFragment extends Fragment implements MainContract.View {

    private MainContract.Delegate mDelegate;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDelegate = new FirstDelegate(this, true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store_discounts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int arguments = getArguments().getInt("perfume_to_watch");
        recyclerView = view.findViewById(R.id.recycler_view);

        if(arguments == 0) {
            arguments = 10;
        }


        List<String> store_items = showItems(arguments);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        MyCustomRecyclerViewAdapter recyclerViewAdapter = new MyCustomRecyclerViewAdapter(getActivity(), store_items);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    public List<String> showItems(int quantity){
        return mDelegate.onViewCreatedForDelegate(quantity);
    }
}
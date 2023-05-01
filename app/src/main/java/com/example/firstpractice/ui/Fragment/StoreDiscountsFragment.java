package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstpractice.R;
import com.example.firstpractice.ui.Adapter.MyCustomRecyclerViewAdapter;
import com.example.firstpractice.ui.Presenter.StoreDiscountsPresenter;

import java.util.List;


public class StoreDiscountsFragment extends Fragment {

    private StoreDiscountsPresenter mDelegate;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDelegate = new StoreDiscountsPresenter(this, true);
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

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_store);
        final MyCustomRecyclerViewAdapter adapter = new MyCustomRecyclerViewAdapter(new MyCustomRecyclerViewAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public List<String> showItems(int quantity){
        return mDelegate.onViewCreatedForDelegate(quantity);
    }
}
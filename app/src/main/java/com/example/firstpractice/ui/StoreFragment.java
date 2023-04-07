package com.example.firstpractice.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firstpractice.MainContract;
import com.example.firstpractice.MyCustomListViewAdapter;
import com.example.firstpractice.R;
import com.example.firstpractice.domain.FirstDelegate;

import java.util.ArrayList;
import java.util.List;


public class StoreFragment extends Fragment implements MainContract.View {

    private MainContract.Delegate mDelegate;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDelegate = new FirstDelegate(this, false);
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

        int arguments = getArguments().getInt("perfume_to_watch");

        if(arguments == 0){
            arguments = 10;
        }

        List<String> store_items = showItems(arguments);

        MyCustomListViewAdapter listViewAdapter = new MyCustomListViewAdapter(getActivity(), R.layout.store_item, store_items);

        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), store_items.get(i), Toast.LENGTH_SHORT).show();
                Log.i("ListView", store_items.get(i));
            }
        });
    }

    @Override
    public List<String> showItems(int quantity) {
        return mDelegate.onViewCreatedForDelegate(quantity);
    }

    @Override
    public FragmentActivity getFragmentActivity() {
        return getActivity();
    }
}
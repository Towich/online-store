package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firstpractice.ui.Adapter.MyCustomListViewAdapter;
import com.example.firstpractice.R;
import com.example.firstpractice.ui.Presenter.StorePresenter;

import java.util.List;


public class StoreFragment extends Fragment{

    private StorePresenter mDelegate;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDelegate = new StorePresenter(this, false);
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

    public List<String> showItems(int quantity) {
        return mDelegate.onViewCreatedForDelegate(quantity);
    }
}
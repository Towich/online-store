package com.example.firstpractice.domain;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstpractice.MainContract;
import com.example.firstpractice.MyCustomRecyclerViewAdapter;
import com.example.firstpractice.model.Perfumes;

import java.util.List;

public class FirstDelegate implements MainContract.Delegate {

    // Components
    private MainContract.View mView;
    private MainContract.Repository mRepository;

    private boolean premiumPerfume;

    public FirstDelegate(MainContract.View mView, boolean premiumPerfume){
        this.mView = mView;
        this.mRepository = new Perfumes(premiumPerfume);
    }

    @Override
    public List<String> onViewCreatedForDelegate(int quantity) {
        List<String> store_items = mRepository.CreateListOfItems(quantity);
        return store_items;
    }
}

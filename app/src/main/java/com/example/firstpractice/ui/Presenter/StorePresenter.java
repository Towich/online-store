package com.example.firstpractice.ui.Presenter;

import com.example.firstpractice.data.resources.PerfumesModel;
import com.example.firstpractice.ui.Fragment.StoreFragment;

import java.util.List;

public class StorePresenter {

    // Components
    private final StoreFragment mView;
    private final PerfumesModel mRepository;

    private boolean premiumPerfume;

    public StorePresenter(StoreFragment mView, boolean premiumPerfume){
        this.mView = mView;
        this.mRepository = new PerfumesModel(premiumPerfume);
    }

    public List<String> onViewCreatedForDelegate(int quantity) {
        if(quantity == 0){
            quantity = 10;
        }
        List<String> store_items = mRepository.CreateListOfItems(quantity);
        return store_items;
    }
}

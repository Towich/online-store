package com.example.firstpractice.ui.Presenter;

import com.example.firstpractice.data.resources.PerfumesModel;
import com.example.firstpractice.ui.Fragment.StoreDiscountsFragment;

import java.util.List;

public class StoreDiscountsPresenter {

    // Components
    private final StoreDiscountsFragment mView;
    private final PerfumesModel mRepository;

    private boolean premiumPerfume;

    public StoreDiscountsPresenter(StoreDiscountsFragment mView, boolean premiumPerfume){
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

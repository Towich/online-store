package com.example.firstpractice.ui.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.example.firstpractice.data.workers.StockWorker;

public class ParseStockViewModel extends AndroidViewModel {

    private final WorkManager mWorkManager;
    private OneTimeWorkRequest myWorkRequest;

    public MutableLiveData<String> stock_price; // LiveData

    public ParseStockViewModel(@NonNull Application application) {
        super(application);
        mWorkManager = WorkManager.getInstance();

    }

    public void receiveStockPrice(){
        mWorkManager.enqueue(myWorkRequest);
    }

    public String getStockPrice(){
        return stock_price.getValue();
    }
}

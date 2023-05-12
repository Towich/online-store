package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.firstpractice.R;
import com.example.firstpractice.data.workers.StockWorker;
import com.example.firstpractice.ui.ViewModel.ContactsViewModel;
import com.example.firstpractice.ui.ViewModel.ParseStockViewModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ParseStockFragment extends Fragment {

    private ParseStockViewModel mParseStockViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parse_stock, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mParseStockViewModel = new ViewModelProvider(this).get(ParseStockViewModel.class);

        ExecutorService service = Executors.newFixedThreadPool(3);
        TextView text_view_stock1_price = view.findViewById(R.id.text_view_stock1_price);
        TextView text_view_stock2_price = view.findViewById(R.id.text_view_stock2_price);
        Button button_check_price = view.findViewById(R.id.button_check_price);
        OneTimeWorkRequest myWorkRequest = OneTimeWorkRequest.from(StockWorker.class);

        button_check_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLOrealPrice(service, text_view_stock1_price);

                WorkManager.getInstance().enqueue(myWorkRequest);

            }
        });

        WorkManager.getInstance().getWorkInfoByIdLiveData(myWorkRequest.getId())
                .observe(getActivity(), new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(@Nullable WorkInfo workInfo) {
                        if (workInfo != null) {
                            Data progress = workInfo.getOutputData();
                            String value = progress.getString(StockWorker.KEY_STOCK_PRICE);
                            // Do something with progress
                            text_view_stock2_price.setText(value);
                        }
                    }
                });
    }

    private void getLOrealPrice(ExecutorService service, TextView text_view_stock_price){

        // Create a new thread
        Future future = service.submit(new Callable(){
            public Object call() throws Exception {
                Element stock_price_l_oreal = null;    // <div> with the stock's price of L'Oreal

                while (stock_price_l_oreal == null) {
                    Document doc;

                    // Get doc by url
                    doc = Jsoup.connect("https://ru.investing.com/equities/l-oreal").get();

                    // Get <div>
                    stock_price_l_oreal = doc.getElementsByClass("text-5xl").first();
                }

                Log.d("JSOUP", stock_price_l_oreal.text());
                return stock_price_l_oreal.text();
            }
        });

        try {
            String stock_price_l_oreal = future.get().toString() + " EUR";  // get string from second thread
            text_view_stock_price.setText(stock_price_l_oreal);             // change TextView
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
package com.example.firstpractice.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.firstpractice.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ParseStockFragment extends Fragment {
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

        ExecutorService service = Executors.newFixedThreadPool(3);

        TextView text_view_stock_price = view.findViewById(R.id.text_view_stock_price);

        Button button_check_price = view.findViewById(R.id.button_check_price);
        button_check_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create a new thread
                Future future = service.submit(new Callable(){
                    public Object call() throws Exception {
                        Element table_crypto = null;    // <div> with the stock's price of L'Oreal

                        while (table_crypto == null) {
                            Document doc;
                            doc = Jsoup.connect("https://ru.investing.com/equities/l-oreal").get();
                            table_crypto = doc.getElementsByClass("text-5xl").first();
                        }

                        Log.d("JSOUP", table_crypto.text());
                        return table_crypto.text();
                    }
                });

                try {
                    String futureTxt = future.get().toString() + " руб.";
                    text_view_stock_price.setText(futureTxt);
                } catch (ExecutionException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
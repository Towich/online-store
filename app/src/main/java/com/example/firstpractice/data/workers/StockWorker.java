package com.example.firstpractice.data.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class StockWorker extends Worker {

    public static final String KEY_STOCK_PRICE = "KEY_STOCK_PRICE";

    public StockWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Elements stock_price_estee = null;    // <span> with the stock's price of 'Estee Lauder'

        while (stock_price_estee == null) {
            Document doc;

            // Get doc by url
            try {
                doc = Jsoup.connect("https://ru.investing.com/equities/estee-lauder").get();
            } catch (IOException e) {
                Log.e("JSOUP", "FAIL: Can't connect to website!");
                continue;
            }

            // Get <span>
            stock_price_estee = doc.select("span.text-2xl");
        }

        Log.d("JSOUP", stock_price_estee.text());

        // Output the stock's price of 'Estee Launder'
        Data outputData = new Data.Builder()
                .putString(KEY_STOCK_PRICE, stock_price_estee.text() + " USD")
                .build();

        return Result.success(outputData);
    }
}

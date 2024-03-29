package com.example.firstpractice.ui.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.firstpractice.R;

public class CommonPerfumeViewHolder extends RecyclerView.ViewHolder {
    private final TextView commonPerfumeNameItemView;   // TextView of perfume's name
    private final TextView commonPerfumePriceItemView;  // TextView of perfume's price

    private CommonPerfumeViewHolder(View itemView){
        super(itemView);
        commonPerfumeNameItemView = itemView.findViewById(R.id.store_item_name);
        commonPerfumePriceItemView = itemView.findViewById(R.id.store_item_price);
    }

    // Set values in both TextViews
    public void bind(String nameText, int priceText){
        commonPerfumeNameItemView.setText(nameText);
        commonPerfumePriceItemView.setText(Integer.toString(priceText));
    }

    // Create ViewHolder
    static CommonPerfumeViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_item, parent, false);
        return new CommonPerfumeViewHolder(view);
    }
}

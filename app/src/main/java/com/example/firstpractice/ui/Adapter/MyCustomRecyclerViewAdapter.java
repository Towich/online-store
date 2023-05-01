package com.example.firstpractice.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.firstpractice.R;
import com.example.firstpractice.data.databases.entity.CommonPerfumeEntity;

import java.util.List;

public class MyCustomRecyclerViewAdapter extends ListAdapter<CommonPerfumeEntity, CommonPerfumeViewHolder> {

    public MyCustomRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<CommonPerfumeEntity> diffCallback) {
        super(diffCallback);
    }

    @Override
    public CommonPerfumeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonPerfumeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(CommonPerfumeViewHolder holder, int position) {
        CommonPerfumeEntity current = getItem(position);
        holder.bind(current.getName(), current.getPrice());
    }
    public static class WordDiff extends DiffUtil.ItemCallback<CommonPerfumeEntity> {

        @Override
        public boolean areItemsTheSame(@NonNull CommonPerfumeEntity oldItem, @NonNull CommonPerfumeEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CommonPerfumeEntity oldItem, @NonNull CommonPerfumeEntity newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}

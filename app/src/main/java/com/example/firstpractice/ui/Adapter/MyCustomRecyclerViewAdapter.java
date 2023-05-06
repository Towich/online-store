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
import com.example.firstpractice.data.resources.CommonPerfumeModel;

import java.util.List;

public class MyCustomRecyclerViewAdapter extends ListAdapter<CommonPerfumeModel, CommonPerfumeViewHolder> {

    public MyCustomRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<CommonPerfumeModel> diffCallback) {
        super(diffCallback);
    }

    @Override
    public CommonPerfumeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonPerfumeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(CommonPerfumeViewHolder holder, int position) {
        CommonPerfumeModel current = getItem(position);
        holder.bind(current.getName(), current.getPrice());
    }
    public static class WordDiff extends DiffUtil.ItemCallback<CommonPerfumeModel> {

        @Override
        public boolean areItemsTheSame(@NonNull CommonPerfumeModel oldItem, @NonNull CommonPerfumeModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CommonPerfumeModel oldItem, @NonNull CommonPerfumeModel newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}

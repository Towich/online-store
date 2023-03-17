package com.example.firstpractice;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyCustomRecyclerViewAdapter extends RecyclerView.Adapter<MyCustomRecyclerViewAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<String> store_items;
    private Context context;

    public MyCustomRecyclerViewAdapter(Context context, List<String> items){
        store_items = items;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return store_items.size();
    }

    @NonNull
    @Override
    public MyCustomRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.store_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCustomRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.store_item_text.setText(store_items.get(position));
        holder.store_item_image.setImageResource(R.drawable._551570);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, store_items.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                Log.i("RecyclerView", store_items.get(holder.getAdapterPosition()));
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView store_item_text;
        ImageView store_item_image;

        public ViewHolder(View view){
            super(view);
            store_item_text = view.findViewById(R.id.store_item_text);
            store_item_image = view.findViewById(R.id.store_item_image);
        }
    }
}



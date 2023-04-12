package com.example.firstpractice.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstpractice.R;

import java.util.List;

public class MyCustomListViewAdapter extends ArrayAdapter<String> {

    private LayoutInflater inflater;
    private int layout;
    private List<String> store_items;

    public MyCustomListViewAdapter(Context context, int resource, List<String> store_items){
        super(context, resource, store_items);
        this.store_items = store_items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = inflater.inflate(this.layout, parent, false);

        TextView store_item_text = view.findViewById(R.id.store_item_text);
        store_item_text.setText(store_items.get(position));

        ImageView store_item_image = view.findViewById(R.id.store_item_image);
        store_item_image.setImageResource(R.drawable._551570);

        return view;
    }
}

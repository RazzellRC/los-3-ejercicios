package com.example.app_android_usando_adapters.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_android_usando_adapters.R;
import com.example.app_android_usando_adapters.models.MenuItem;

import java.util.List;

public class MenuAdapter extends BaseAdapter {
    private Context context;
    private List<MenuItem> items;

    public MenuAdapter(Context context, List<MenuItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        }

        MenuItem item = items.get(position);

        TextView tvTitulo = v.findViewById(R.id.tvTituloMenu);
        ImageView ivIcono = v.findViewById(R.id.ivIconoMenu);

        tvTitulo.setText(item.getTitulo());
        ivIcono.setImageResource(item.getIconoResId());

        return v;
    }
}


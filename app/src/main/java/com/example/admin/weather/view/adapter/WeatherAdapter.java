package com.example.admin.weather.view.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.weather.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private String[] days;

    public WeatherAdapter(Context context, String[] days) {
        this.context = context;
        this.days = days;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.item_weather,parent,false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Item) holder).txtDays.setText(days[position]);
    }

    @Override
    public int getItemCount() {
        return days.length;
    }

    public class Item extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_days)
        TextView txtDays;

        public Item(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

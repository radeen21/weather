package com.example.admin.weather.view.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.weather.R;
import com.example.admin.weather.model.ForecastWeatherModel;
import com.example.data.weather.model.Forecast;
import com.example.domain.weather.Forecastday;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Forecastday> forecastdays;

    public WeatherAdapter(Context context) {
        this.context = context;
        forecastdays = new ArrayList<>();
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
        Forecastday forecastday = forecastdays.get(position);
        ((Item) holder).txtDays.setText(forecastday.getDate());
    }

    @Override
    public int getItemCount() {
        if (null == forecastdays)
            return 0;
        return forecastdays.size();
    }

    public void addForecast(List<Forecastday> forecastDay) {
        this.forecastdays = forecastDay;
        notifyDataSetChanged();
    }

    public class Item extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_days)
        TextView txtDays;

        public Item(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindData(ForecastWeatherModel forecastWeatherModel) {
//            txtDays.setText(forecastWeatherModel.getForecasts().getForecastday());
        }
    }


}

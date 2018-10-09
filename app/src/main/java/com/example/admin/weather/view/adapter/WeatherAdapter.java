package com.example.admin.weather.view.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.weather.R;
import com.example.admin.weather.model.ForecastWeatherModel;
import com.example.admin.weather.utils.CalendarUtils;
import com.example.data.weather.model.Forecast;
import com.example.domain.weather.Forecastday;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
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

        ((Item) holder).txtDays.setText(CalendarUtils.getDayFromDateString(forecastday.getDate()));
        String tempC = forecastday.getDay().getAvgtempC();
        if (tempC.contains(".")) {
            tempC = tempC.substring(0, tempC.indexOf("."));
        }
        ((Item) holder).txtCelcius.setText(tempC + "\u00B0" +" C");
        Glide.with(context).
                load("https:" + forecastday.getDay().getCondition().getIcon()).
                into(((Item) holder).imgIconWeather);
        ((Item) holder).txtMessageWeather.setText(forecastday.getDay().getCondition().getText());
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

        @BindView(R.id.txt_celcius)
        TextView txtCelcius;

        @BindView(R.id.img_icon_weather)
        ImageView imgIconWeather;

        @BindView(R.id.txt_message_weather)
        TextView txtMessageWeather;

        public Item(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }


}

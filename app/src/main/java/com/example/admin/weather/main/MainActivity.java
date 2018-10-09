package com.example.admin.weather.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.weather.R;
import com.example.admin.weather.base.BaseActivity;
import com.example.admin.weather.di.components.DaggerWeatherComponent;
import com.example.admin.weather.di.components.WeatherComponent;
import com.example.admin.weather.di.module.WeatherModule;
import com.example.admin.weather.model.ForecastWeatherModel;
import com.example.admin.weather.view.adapter.WeatherAdapter;
import com.example.domain.weather.ForeCastWeather;

import java.text.DecimalFormat;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContract.View{

    public String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.recycler_day)
    RecyclerView recyclerDay;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.txt_celcius)
    TextView txtCelcius;

    @BindView(R.id.text_city)
    TextView txtCity;

    @BindView(R.id.iv_icon)
    ImageView ivIcon;

    @BindView(R.id.text_message)
    TextView txtMessage;

    private WeatherAdapter weatherAdapter;

    @Inject
    MainPresenter mainPresenter;

    private WeatherComponent weatherComponent;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setup() {
        init();
        injector();
        bindVIewToPresenter();
        getWeathers();
    }

    private void getWeathers(){
        mainPresenter.doGetWeather();
    }

    private void bindVIewToPresenter() {
        mainPresenter.setView(this);
    }

    private void injector() {
        if (weatherComponent == null) {
                weatherComponent = DaggerWeatherComponent.builder()
                        .applicationComponent(getApplicationComponent())
                        .activityModule(getActivityModule())
                        .weatherModule(new WeatherModule())
                        .build();
        }
        weatherComponent.inject(this);
    }

    private void init() {
        weatherAdapter = new WeatherAdapter(this);
        recyclerDay.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerDay.setAdapter(weatherAdapter);
    }

    @Override
    public void showWeather(ForeCastWeather foreCastWeather) {
        txtCity.setText(foreCastWeather.getLocation().getName());
        String tempC = foreCastWeather.getCurrent().getTemp_c();
        if (tempC.contains(".")) {
            tempC = tempC.substring(0, tempC.indexOf("."));
        }
        txtCelcius.setText(tempC + "\u00B0");
        txtMessage.setText(foreCastWeather.getCurrent().getCondition().getText());
        Glide.with(this).
                load("https:" + foreCastWeather.getCurrent().getCondition().getIcon()).
                into(ivIcon);
    }

    @Override
    public void loadForecast(ForecastWeatherModel forecastWeatherModels) {
        weatherAdapter.addForecast(forecastWeatherModels.getForecastday());

        recyclerDay.setVisibility(View.VISIBLE);
    }

    @Override
    public void showAuthExpiredDialog(Throwable throwable) {

    }

    @Override
    public void showInsecureConnectionDialog(Throwable throwable) {

    }

}

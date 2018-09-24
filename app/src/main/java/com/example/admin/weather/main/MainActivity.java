package com.example.admin.weather.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.weather.R;
import com.example.admin.weather.base.BaseActivity;
import com.example.admin.weather.di.components.DaggerWeatherComponent;
import com.example.admin.weather.di.components.WeatherComponent;
import com.example.admin.weather.di.module.WeatherModule;
import com.example.admin.weather.model.ForecastWeatherModel;
import com.example.admin.weather.view.adapter.WeatherAdapter;
import com.example.domain.weather.ForeCastWeather;

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
        txtCelcius.setText(foreCastWeather.getCurrent().getFeelslike_c() + "\u00B0");
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

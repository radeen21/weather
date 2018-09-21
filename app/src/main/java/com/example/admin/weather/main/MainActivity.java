package com.example.admin.weather.main;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.weather.R;
import com.example.admin.weather.base.BaseActivity;
import com.example.admin.weather.di.components.DaggerWeatherComponent;
import com.example.admin.weather.di.components.WeatherComponent;
import com.example.admin.weather.di.module.AccountModule;
import com.example.admin.weather.di.module.WeatherModule;
import com.example.admin.weather.view.adapter.WeatherAdapter;
import com.example.domain.weather.Locations;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

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

//    String[] days = {"senin", "selasa", "rabu", "kamis"};

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//
//        getWeathers();
//        setup();
//    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setup() {
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

    @Override
    public void showWeather(Locations locations) {
        txtCity.setText(locations.getName());
    }

    @Override
    public void showAuthExpiredDialog(Throwable throwable) {

    }

    @Override
    public void showInsecureConnectionDialog(Throwable throwable) {

    }

//    private void setup() {
//        int resId = R.anim.slide_out_bottom;
//
//
//        weatherAdapter = new WeatherAdapter(this,days);
//        recyclerDay.setLayoutManager(new LinearLayoutManager(this));
//        recyclerDay.setAdapter(weatherAdapter);
//        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this,resId);
//        recyclerDay.setLayoutAnimation(animation);
//        this.overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_top);
//    }
}

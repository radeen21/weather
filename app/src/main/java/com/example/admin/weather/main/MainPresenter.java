package com.example.admin.weather.main;

import com.example.admin.weather.base.BasePresenter;
import com.example.admin.weather.model.mapper.ForecastWeatherMapper;
import com.example.domain.DefaultSubscriber;
import com.example.domain.weather.ForeCastWeather;
import com.example.domain.weather.GetWeather;
import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{

    GetWeather getWeather;

    private ForecastWeatherMapper forecastWeatherMapper;

    @Inject
    public MainPresenter(GetWeather getWeather, ForecastWeatherMapper forecastWeatherMapper) {
        this.getWeather = getWeather;
        this.forecastWeatherMapper = forecastWeatherMapper;
    }


    @Override
    public void doGetWeather() {
        getWeather.execute(new DefaultSubscriber<ForeCastWeather>(){
            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(ForeCastWeather foreCastWeather) {
                super.onNext(foreCastWeather);
                getView().showWeather(foreCastWeather);
                getView().loadForecast(forecastWeatherMapper.transform(foreCastWeather));
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
            }
        });
    }

    @Override
    protected void onDestroy() {
        getWeather.clearAllSubscription();
    }
}

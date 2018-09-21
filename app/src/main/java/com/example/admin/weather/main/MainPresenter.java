package com.example.admin.weather.main;

import com.example.admin.weather.base.BasePresenter;
import com.example.domain.DefaultSubscriber;
import com.example.domain.weather.GetWeather;
import com.example.domain.weather.Locations;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{

    GetWeather getWeather;

    @Inject
    public MainPresenter(GetWeather getWeather) {
        this.getWeather = getWeather;
    }


    @Override
    public void doGetWeather() {
        getWeather.execute(new DefaultSubscriber<Locations>(){
            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(Locations locations) {
                super.onNext(locations);
                getView().showWeather(locations);
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

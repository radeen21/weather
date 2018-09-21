package com.example.admin.weather;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.admin.weather.di.components.ApplicationComponent;
import com.example.admin.weather.di.components.DaggerApplicationComponent;
import com.example.admin.weather.di.module.ApplicationModule;

public class WeatherApplication extends MultiDexApplication {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
    }

    private void initInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    // Install multi dex compatible
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}

package com.example.admin.weather.di.components;

import com.example.admin.weather.main.MainActivity;
import com.example.admin.weather.di.module.ActivityModule;
import com.example.admin.weather.di.module.WeatherModule;
import com.example.admin.weather.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class,
        WeatherModule.class})
public interface WeatherComponent extends ActivityComponent{

    void inject(MainActivity activity);
}

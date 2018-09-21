package com.example.admin.weather.di.components;

import android.app.Activity;

import com.example.admin.weather.base.BaseActivity;
import com.example.admin.weather.di.module.ActivityModule;
import com.example.admin.weather.di.module.ConfigModule;
import com.example.admin.weather.di.module.WeatherModule;
import com.example.admin.weather.di.scope.PerActivity;
import com.example.admin.weather.main.MainActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class,
        WeatherModule.class})
public interface ActivityComponent {

    BaseActivity activity();

}
package com.example.admin.weather.di.components;

import android.app.Activity;

import com.example.admin.weather.base.BaseActivity;
import com.example.admin.weather.di.module.ApplicationModule;
import com.example.domain.weather.repository.LocationsRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject (BaseActivity baseActivity);

    LocationsRepository locationsRepository();

}

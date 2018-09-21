package com.example.admin.weather.di.module;

import android.app.Activity;

import com.example.admin.weather.base.BaseActivity;
import com.example.admin.weather.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private BaseActivity baseActivity;

    public ActivityModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Provides
    @PerActivity
    BaseActivity provideActivity() {
        return baseActivity;
    }

}

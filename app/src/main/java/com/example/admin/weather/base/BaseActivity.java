package com.example.admin.weather.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.weather.WeatherApplication;
import com.example.admin.weather.di.components.ApplicationComponent;
import com.example.admin.weather.di.module.ActivityModule;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViews();
        setup();
    }

    public void findViews() {
        if (0 != getLayout()) {
            setContentView(getLayout());
            unbinder = ButterKnife.bind(this);
        }
    }

    public abstract int getLayout();

    public abstract void setup();

    public ApplicationComponent getApplicationComponent() {
        return ((WeatherApplication) getApplication()).getApplicationComponent();
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}

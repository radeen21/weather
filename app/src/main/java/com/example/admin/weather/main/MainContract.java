package com.example.admin.weather.main;

import com.example.admin.weather.base.BaseContractView;
import com.example.data.weather.model.Location;
import com.example.domain.weather.Locations;

public interface MainContract {

    interface View extends BaseContractView {

        void showWeather(Locations locations);

    }

    interface Presenter {

        void doGetWeather();

    }
}

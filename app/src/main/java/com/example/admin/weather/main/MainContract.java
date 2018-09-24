package com.example.admin.weather.main;

import com.example.admin.weather.base.BaseContractView;
import com.example.admin.weather.model.ForecastWeatherModel;
import com.example.domain.weather.ForeCastWeather;

public interface MainContract {

    interface View extends BaseContractView {

        void showWeather(ForeCastWeather foreCastWeather);

        void loadForecast(ForecastWeatherModel forecastWeatherModels);

    }

    interface Presenter {

        void doGetWeather();

    }
}

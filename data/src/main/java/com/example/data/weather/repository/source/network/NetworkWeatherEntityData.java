package com.example.data.weather.repository.source.network;

import com.example.data.network.BaseNetwork;
import com.example.data.weather.WeatherEntity;
import com.example.data.weather.repository.source.WeatherEntityDatas;
import com.example.data.weather.repository.source.network.response.WeatherInquiryResponse;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class NetworkWeatherEntityData extends BaseNetwork<WeatherApi> implements WeatherEntityDatas {

    public NetworkWeatherEntityData() {

    }

    @Override
    protected Class<WeatherApi> getNetworkClass() {
        return WeatherApi.class;
    }

    @Override
    protected String getBaseUrl() {
        return "https://api.apixu.com/";
    }

    @Override
    public Observable<WeatherInquiryResponse> getWeather() {
        return getNetworkService()
                .getLocations(
                        "af24415233474fd29af42509182308",
                        "jakarta",
                        1).subscribeOn(Schedulers.io());
    }
}

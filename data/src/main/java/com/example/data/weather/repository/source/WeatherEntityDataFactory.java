package com.example.data.weather.repository.source;

import com.example.data.AbstractEntityDataFactory;
import com.example.data.weather.repository.source.network.NetworkWeatherEntityData;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WeatherEntityDataFactory extends AbstractEntityDataFactory<WeatherEntityDatas> {

    @Inject
    public WeatherEntityDataFactory(){

    }

    @Override
    public WeatherEntityDatas createData() {
        return new NetworkWeatherEntityData();
    }
}

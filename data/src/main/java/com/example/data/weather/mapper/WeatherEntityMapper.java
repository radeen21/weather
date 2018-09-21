package com.example.data.weather.mapper;

import com.example.data.weather.WeatherEntity;
import com.example.data.weather.repository.source.network.response.WeatherInquiryResponse;
import com.example.domain.weather.Locations;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WeatherEntityMapper {

    @Inject
    public WeatherEntityMapper() {
    }

    public Locations transform(WeatherInquiryResponse weatherEntity) {
        Locations location = null;

        if (weatherEntity != null) {
            location = new Locations();
            location.setName(weatherEntity.getLocation().getName());
            location.setRegion(weatherEntity.getLocation().getRegion());
            location.setCountry(weatherEntity.getLocation().getCountry());
            location.setLat(weatherEntity.getLocation().getLat());
            location.setLon(weatherEntity.getLocation().getLon());
            location.setTz_id(weatherEntity.getLocation().getTz_id());
            location.setLocaltime_epoch(weatherEntity.getLocation().getLocaltime_epoch());
            location.setLocaltime(weatherEntity.getLocation().getLocaltime());
        }

        return location;

    }
}

package com.example.data.network;

public class WeatherNetwork extends BaseNetwork {

    @Override
    protected Class getNetworkClass() {
        return null;
    }

    @Override
    protected String getBaseUrl() {
        return "https://api.apixu.com/v1/";
    }
}

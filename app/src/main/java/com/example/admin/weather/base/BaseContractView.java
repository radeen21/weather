package com.example.admin.weather.base;

public interface BaseContractView {

    void showAuthExpiredDialog(Throwable throwable);

    void showInsecureConnectionDialog(Throwable throwable);

}
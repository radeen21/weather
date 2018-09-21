package com.example.admin.weather.base;

public interface IBasePresenter<T extends IBaseView> {

    void onAttach(T view);
    void onDetach();
    boolean isAttached();
}

package com.example.domain.weather;

import com.example.domain.UseCase;
import com.example.domain.weather.repository.LocationsRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetWeather extends UseCase<Locations, Void> {

    private LocationsRepository locationsRepository;

    @Inject
    public GetWeather(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }


    @Override
    protected Observable<Locations> buildUseCaseObservable(Void aVoid) {
        return locationsRepository.locationsObservable().observeOn(AndroidSchedulers.mainThread());
    }


}

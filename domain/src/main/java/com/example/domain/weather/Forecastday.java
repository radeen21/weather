package com.example.domain.weather;

import com.google.gson.annotations.SerializedName;

public class Forecastday {

    @SerializedName("date")
    private String date;
    @SerializedName("date_epoch")
    private String dateEpoch;
    @SerializedName("day")
    private Day day;
    @SerializedName("astro")
    private Astro astro;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateEpoch() {
        return dateEpoch;
    }

    public void setDateEpoch(String dateEpoch) {
        this.dateEpoch = dateEpoch;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }
}

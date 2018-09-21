package com.example.domain.weather;

import com.google.gson.annotations.SerializedName;

public class Day {

    @SerializedName("maxtemp_c")
    private String maxtempC;
    @SerializedName("maxtemp_f")
    private String maxtempF;
    @SerializedName("mintemp_c")
    private String mintempC;
    @SerializedName("mintemp_f")
    private String mintempF;
    @SerializedName("avgtemp_c")
    private String avgtempC;
    @SerializedName("avgtemp_f")
    private String avgtempF;
    @SerializedName("maxwind_mph")
    private String maxwindMph;
    @SerializedName("maxwind_kph")
    private String maxwindKph;
    @SerializedName("totalprecip_mm")
    private String totalprecipMm;
    @SerializedName("totalprecip_in")
    private String totalprecipIn;
    @SerializedName("avgvis_km")
    private String avgvisKm;
    @SerializedName("avgvis_miles")
    private String avgvisMiles;
    @SerializedName("avghumidity")
    private String avghumidity;
    @SerializedName("condition")
    private Condition condition;
    @SerializedName("uv")
    private String uv;

    public String getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    public String getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(String maxtempF) {
        this.maxtempF = maxtempF;
    }

    public String getMintempC() {
        return mintempC;
    }

    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }

    public String getMintempF() {
        return mintempF;
    }

    public void setMintempF(String mintempF) {
        this.mintempF = mintempF;
    }

    public String getAvgtempC() {
        return avgtempC;
    }

    public void setAvgtempC(String avgtempC) {
        this.avgtempC = avgtempC;
    }

    public String getAvgtempF() {
        return avgtempF;
    }

    public void setAvgtempF(String avgtempF) {
        this.avgtempF = avgtempF;
    }

    public String getMaxwindMph() {
        return maxwindMph;
    }

    public void setMaxwindMph(String maxwindMph) {
        this.maxwindMph = maxwindMph;
    }

    public String getMaxwindKph() {
        return maxwindKph;
    }

    public void setMaxwindKph(String maxwindKph) {
        this.maxwindKph = maxwindKph;
    }

    public String getTotalprecipMm() {
        return totalprecipMm;
    }

    public void setTotalprecipMm(String totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
    }

    public String getTotalprecipIn() {
        return totalprecipIn;
    }

    public void setTotalprecipIn(String totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
    }

    public String getAvgvisKm() {
        return avgvisKm;
    }

    public void setAvgvisKm(String avgvisKm) {
        this.avgvisKm = avgvisKm;
    }

    public String getAvgvisMiles() {
        return avgvisMiles;
    }

    public void setAvgvisMiles(String avgvisMiles) {
        this.avgvisMiles = avgvisMiles;
    }

    public String getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(String avghumidity) {
        this.avghumidity = avghumidity;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }
}

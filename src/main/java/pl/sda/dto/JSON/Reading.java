package pl.sda.dto.JSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Getter
@Setter
@Entity
public class Reading {
    @JsonIgnoreProperties(value = {"dt", "sunrise", "sunset", "feels_like", "humidity", "dew_point", "weather", "clouds", "pop", "rain"})
    //@JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("dt")
    @Transient
    private int dt;
    @JsonProperty("sunrise")
    @Transient
    private int sunrise;
    @JsonProperty("sunset")
    @Transient
    private int sunset;
    @JsonProperty("temp")
    private TemperatureDTO temp;
    @JsonProperty("feels_like")
    @Transient
    private Object feels_like;
    @JsonProperty("pressure")
    private int pressure;
    @JsonProperty("humidity")
    @Transient
    private int humidity;
    @JsonProperty("dew_point")
    @Transient
    private int dew_point;
    @JsonProperty("wind_speed")
    private float wind_speed;
    @JsonProperty("wind_deg")
    private float wind_deg;
    @JsonProperty("weather")
    @Transient
    private Object weather;
    @JsonProperty("clouds")
    @Transient
    private int clouds;
    @JsonProperty("pop")
    @Transient
    private double pop;
    @JsonProperty("rain")
    @Transient
    private double rain;

    @Transient
    private int cityId;
}

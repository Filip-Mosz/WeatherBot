package pl.sda.dto.JSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
public class ReadingDTO {
    @JsonIgnoreProperties(value = {"uvi", "dt", "sunrise", "sunset", "feels_like", "humidity", "dew_point", "weather", "clouds", "pop", "rain"})
    //@JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("dt")
    private int dt;
    @JsonProperty("sunrise")
    private int sunrise;
    @JsonProperty("sunset")
    private int sunset;
    @JsonProperty("temp")
    @Column(name = "Temperature")
    private TemperatureDTO temp; //dodatkowa tabela
    @JsonProperty("feels_like")
    private Object feels_like;
    @JsonProperty("pressure")
    private int pressure;
    @JsonProperty("humidity")
    private int humidity;
    @JsonProperty("dew_point")
    private int dew_point;
    @JsonProperty("wind_speed")
    private float wind_speed;
    @JsonProperty("wind_deg")
    private float wind_deg;
    @JsonProperty("weather")
    private Object weather;
    @JsonProperty("clouds")
    private int clouds;
    @JsonProperty("pop")
    private double pop;
    @JsonProperty("rain")
    private double rain;
    @JsonProperty("uvi")
    private double uvi;



    public String getStringValueOfWind_deg() {
        String direction = "N";
        if (22.5 < wind_deg && wind_deg < 67.5){
            direction = "NE";
        } else if (67.5 < wind_deg && wind_deg < 112.5){
            direction = "E";
        } else if (112.5 < wind_deg && wind_deg < 157.5){
            direction = "SE";
        } else if (157.5 < wind_deg && wind_deg < 202.5){
            direction = "S";
        } else if (202.5 < wind_deg && wind_deg < 247.5){
            direction = "SW";
        } else if (247.5 < wind_deg && wind_deg < 292.5){
            direction = "W";
        } else if (292.5 < wind_deg && wind_deg < 337.5){
            direction = "NW";
        }
        return direction;
    }
}

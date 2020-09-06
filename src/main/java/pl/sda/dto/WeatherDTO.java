package pl.sda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class WeatherDTO {
//    @JsonProperty("coord") //może się przydać dla upewnienia, że to pogoda dla wybranej lokacji
//    private CoordinatesDTO coordinates;
    @JsonProperty("main:temp")
    private float temperature;
    @JsonProperty("main:pressure")
    private float pressure;
    @JsonProperty("wind:deg")
    private int windDirection;
    @JsonProperty("wind:speed")
    private float windSpeed;

}

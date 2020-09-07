package pl.sda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {
//    @JsonProperty("coord") //może się przydać dla upewnienia, że to pogoda dla wybranej lokacji
//    private CoordinatesDTO coordinates;
    @JsonProperty("temp")
    private float temperature;
    @JsonProperty("pressure")
    private float pressure;
    @JsonProperty("deg")
    private int windDirection;
    @JsonProperty("speed")
    private float windSpeed;

}
//https://sdacademy.pl/poradnik-absolwenta/deserializacja-jsona-w-javie/

// {} obiekt
// [] lista

package pl.sda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.sda.dto.JSON.TemperatureDTO;
import pl.sda.dto.JSON.WindDTO;

@Getter
@Setter
@JsonIgnoreProperties(value ={"weather", "sys", "base", "clouds", "dt", "name", "cod", "visibility"})
public class WeatherDTO {
    @JsonProperty("coord") //może się przydać dla upewnienia, że to pogoda dla wybranej lokacji
    private CoordinatesDTO coordinates;
    @JsonProperty("main") //
    private TemperatureDTO temperature;
    @JsonProperty("wind")
    private WindDTO windDTO;
    @JsonProperty("id")
    private int id;
}


// {} obiekt
// [] lista

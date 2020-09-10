package pl.sda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.sda.dto.JSON.TemperatureDTO;
import pl.sda.dto.JSON.WindDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties(value ={"coord", "weather", "sys", "base", "clouds", "dt", "name", "cod", "visibility"})
//@Entity(name = "conditions")
public class WeatherDTO {
    @JsonProperty("main")
    @Column(name = "temperature")
    private TemperatureDTO temperature;
    @JsonProperty("wind")
    @Column(name = "wind")
    private WindDTO windDTO;
    @JsonProperty("id")
    private int id;

    private LocalDate forcastedDay;
}


// {} obiekt
// [] lista

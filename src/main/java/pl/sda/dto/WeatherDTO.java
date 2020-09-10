package pl.sda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.sda.dto.JSON.Reading;

import java.util.List;

@Getter
@Setter
//@JsonIgnoreProperties(value ={"coord", "weather", "sys", "base", "clouds", "dt", "name", "cod", "visibility"})
@JsonIgnoreProperties(value ={"lat","lon", "timezone", "timezone_offset"})
public class WeatherDTO {
    @JsonProperty("daily")
    private List<Reading> readingOfDay;
    //obiekt daily -> lista 1

//    @Column(name = "temperature")
//    private TemperatureDTO temperature;
//    private int pressure;
//    @JsonProperty("wind_speed")
//    @Column(name = "wind_speed")
//    private double windspeed;
//    @JsonProperty("wind_deg")
//    @Column(name = "wind_deg")
//    private double winddeg;

    //private LocalDate forcastedDay;
}


// {} obiekt
// [] lista

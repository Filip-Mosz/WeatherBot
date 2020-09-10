package pl.sda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.sda.dto.JSON.Day;
import pl.sda.dto.JSON.TemperatureDTO;
import pl.sda.dto.JSON.WindDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
//@JsonIgnoreProperties(value ={"coord", "weather", "sys", "base", "clouds", "dt", "name", "cod", "visibility"})
@JsonIgnoreProperties(value ={"lat","lon", "timezone", "timezone_offset", "0","2","3","4","5","6","7", "feels_like", "dt",
"sunrise", "sunset", "dew_point","weather", "clouds", "pop", "humidity",})
public class WeatherDTO {
    @JsonProperty("daily")
    private Object[] day;
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

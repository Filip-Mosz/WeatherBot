package pl.sda.dto.JSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@JsonIgnoreProperties(value = {"temp_min", "temp_max"})
public class TemperatureDTO {
    @Column(name = "temperature")
    private Float temp; //K -> C
    @Column(name = "pressure")
    private Integer pressure;
    @Column(name = "humidity")
    private Integer humidity;


}

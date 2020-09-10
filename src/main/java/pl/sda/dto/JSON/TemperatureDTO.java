package pl.sda.dto.JSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@JsonIgnoreProperties(value = {"min", "max", "eve", "morn"})
public class TemperatureDTO {
    @Column(name = "temperature_day")
    @JsonProperty("day")
    private Float day; //K -> C
    @Column(name = "temperature_night")
    @JsonProperty("night")
    private Integer night; //K -> C


}

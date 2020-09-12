package pl.sda.dto.JSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Getter
@Setter
@SecondaryTable(
        name = "temperature",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "temperature"))
@JsonIgnoreProperties(value = {"min", "max", "eve", "morn"})
public class TemperatureDTO {
    @Column(name = "temperature_day")
    @JsonProperty("day")
    private float day; //K -> C
    @Column(name = "temperature_night")
    @JsonProperty("night")
    private float night; //K -> C


}

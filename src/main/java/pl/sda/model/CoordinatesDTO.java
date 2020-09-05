package pl.sda.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoordinatesDTO {

    @JsonProperty("lon")
    private double longitude;
    @JsonProperty("lat")
    private double latitude;
}

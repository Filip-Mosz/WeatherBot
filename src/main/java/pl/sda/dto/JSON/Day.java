package pl.sda.dto.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class Day {
    @Column(name = "temperature")
    private TemperatureDTO temperature;
    private int pressure;
    @JsonProperty("wind_speed")
    @Column(name = "wind_speed")
    private double windspeed;
    @JsonProperty("wind_deg")
    @Column(name = "wind_deg")
    private double winddeg;
}

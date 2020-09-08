package pl.sda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.sda.dto.JSON.CloudsDTO;
import pl.sda.dto.JSON.SystemDTO;
import pl.sda.dto.JSON.TemperatureDTO;
import pl.sda.dto.JSON.WindDTO;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {
    @JsonProperty("coord") //może się przydać dla upewnienia, że to pogoda dla wybranej lokacji
    private CoordinatesDTO coordinates;
    @JsonProperty("weather")
    List<Object> weatherConditions; //obiekt 0 i Obiekt base
    @JsonProperty("main") //
    private TemperatureDTO temperature;
    //@JsonProperty("visibility") //what if i comment it out?
    private long visibility;
    @JsonProperty("wind")
    private WindDTO windDTO;
    @JsonProperty("clouds")
    private CloudsDTO cloudsDTO;
    private int dt;
    @JsonProperty("sys")
    private SystemDTO systemDTO;
    private int id;
    private String name;
    private int cod;

}
/*      obiektu coord
        listy weather
        pola base
        obiektu main (ten mnie interesuje 2 pola)
        obiektu wind (ten interesuje mnie jako całość)
        obiektu clouds
        pola dt
        obiektu sys
        pola id (id miasta)
        pola name (nazwa miasta)
        pola cod*/
//https://sdacademy.pl/poradnik-absolwenta/deserializacja-jsona-w-javie/

// {} obiekt
// [] lista

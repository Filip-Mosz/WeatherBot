package pl.sda.inbound;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.dto.LocationDTO;
import pl.sda.dto.WeatherDTO;
import pl.sda.model.Location;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class DataMapper {

    public static LocationDTO mapJsonToLocationDTO(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        LocationDTO LocationDTO = null;
        try {
            LocationDTO = objectMapper.readValue(json, LocationDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return LocationDTO;
    }
    public static WeatherDTO mapJsonToWeatherDTO(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherDTO weatherDTO = null;
        try {
            weatherDTO = objectMapper.readValue(json, WeatherDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return weatherDTO;
    }


}

package pl.sda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import pl.sda.model.Location;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class LocationDTO {
    @JsonProperty("coord")
    private CoordinatesDTO coordinates;

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String countryCode;
    final String PATH = "src/main/resources/city.list.json";

    public String JSONGetter(String path) {//excepts trashcode it works
        ObjectMapper mapper = new ObjectMapper();
        Location location = new Location();
        try {
            final URL testUrl = new URL(path);
            StringBuilder jsonText = new StringBuilder();
            try (InputStream myInputStream = testUrl.openStream();
                 Scanner scan = new Scanner(myInputStream)
            ) {
                while (scan.hasNextLine()) {
                    jsonText.append(scan.nextLine());
                }
                return jsonText.toString();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String JSONGetter() {//excepts trashcode it works
        ObjectMapper mapper = new ObjectMapper();
        Location location = new Location();
        try {
            final URL testUrl = new URL("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=62e8e14917f87e5db0d505a8f50b4449");
            StringBuilder jsonText = new StringBuilder();
            try (InputStream myInputStream = testUrl.openStream();
                 Scanner scan = new Scanner(myInputStream)
            ) {
                while (scan.hasNextLine()) {
                    jsonText.append(scan.nextLine());
                }
                return jsonText.toString();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
            return null;
        }
//        try {
//            mapper.writeValue(new URL("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=62e8e14917f87e5db0d505a8f50b4449"), WeatherDTO);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "coordinates=" + coordinates +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
//ToDo wyciągnąć kod ciągnący jsony do osobnej klasy i przemodelować, żeby dał się tam wepchnąć id miasta i wyciągać w ten sposób wyniki pogodowe
//TODO po odczycie stanu pogodowego jsonem przygotować klasę, która wynik wyśle do bazy
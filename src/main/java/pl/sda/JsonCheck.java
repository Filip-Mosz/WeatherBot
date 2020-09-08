package pl.sda;

import pl.sda.dto.LocationDTO;
import pl.sda.dto.WeatherDTO;
import pl.sda.inbound.DataMapper;

public class JsonCheck {
    public static void main(String[] args) {
        LocationDTO dtoCheck = new LocationDTO();
        String check = dtoCheck.JSONGetter();
        System.out.println(check);


        //spróbuję z jsonem pisanym z reki
        String hand = "{\n" +
                "\"temp\":69,\n" +
                "\"pressure\":666,\n" +
                "\"deg\":189,\n" +
                "\"speed\":999\n" +
                //"\"splid\":777\n" +
                "}";
        WeatherDTO weather = DataMapper.mapJsonToWeatherDTO(check);
        System.out.println(weather.getVisibility());
    }
}

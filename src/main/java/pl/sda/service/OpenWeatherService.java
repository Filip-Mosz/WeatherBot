package pl.sda.service;

import pl.sda.model.Location;

public class OpenWeatherService {

    public static String getData(Location location) {
        String lattitude = location.getGPS_location();
        String longitude = location.getGPS_location();

        StringBuilder urlBuilder = new StringBuilder("https://api.openweathermap.org/data/2.5/onecall?lat=");
        urlBuilder.append(lattitude);
        urlBuilder.append("&lon=");
        urlBuilder.append(longitude);
        urlBuilder.append("&exclude=current,hourly,minutely&appid=62e8e14917f87e5db0d505a8f50b4449");


        return JsonService.get(urlBuilder.toString());
    }
}

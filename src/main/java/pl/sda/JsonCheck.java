package pl.sda;

import pl.sda.dto.LocationDTO;
import pl.sda.dto.WeatherDTO;
import pl.sda.inbound.DataMapper;
import pl.sda.service.JsonService;

import java.util.Arrays;

public class JsonCheck {
    public static void main(String[] args) {
        LocationDTO dtoCheck = new LocationDTO();
        //String testUrl = "https://api.openweathermap.org/data/2.5/onecall?lat=54.361099&lon=18.689699&exclude=current,hourly,minutely&appid=62e8e14917f87e5db0d505a8f50b4449";
        String check = "{\"lat\":54.36,\"lon\":18.69,\"timezone\":\"Europe/Warsaw\",\"timezone_offset\":7200,\"daily\":[{\"dt\":1599732000,\"sunrise\":1599710983,\"sunset\":1599758093,\"temp\":{\"day\":289.5,\"min\":282.39,\"max\":290.31,\"night\":283.77,\"eve\":289.28,\"morn\":286.39},\"feels_like\":{\"day\":283.14,\"night\":279.93,\"eve\":283.84,\"morn\":281.64},\"pressure\":1016,\"humidity\":58,\"dew_point\":281.33,\"wind_speed\":8.44,\"wind_deg\":287,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":23,\"pop\":0.29,\"rain\":2.06},{\"dt\":1599818400,\"sunrise\":1599797491,\"sunset\":1599844342,\"temp\":{\"day\":289.27,\"min\":283.91,\"max\":290.56,\"night\":286.17,\"eve\":290.56,\"morn\":283.91},\"feels_like\":{\"day\":285.8,\"night\":282.53,\"eve\":288.13,\"morn\":280.21},\"pressure\":1019,\"humidity\":55,\"dew_point\":280.37,\"wind_speed\":3.98,\"wind_deg\":229,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":67,\"pop\":0},{\"dt\":1599904800,\"sunrise\":1599883999,\"sunset\":1599930590,\"temp\":{\"day\":292.24,\"min\":285.04,\"max\":294.8,\"night\":290.14,\"eve\":294.77,\"morn\":285.04},\"feels_like\":{\"day\":289.41,\"night\":288.08,\"eve\":292.46,\"morn\":281.01},\"pressure\":1018,\"humidity\":59,\"dew_point\":284.13,\"wind_speed\":4.46,\"wind_deg\":222,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":58,\"pop\":0},{\"dt\":1599991200,\"sunrise\":1599970506,\"sunset\":1600016839,\"temp\":{\"day\":290.68,\"min\":287.36,\"max\":292.33,\"night\":289.99,\"eve\":292.23,\"morn\":287.36},\"feels_like\":{\"day\":287.41,\"night\":286.05,\"eve\":289.13,\"morn\":284.77},\"pressure\":1021,\"humidity\":62,\"dew_point\":283.36,\"wind_speed\":4.8,\"wind_deg\":275,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":89,\"pop\":0},{\"dt\":1600077600,\"sunrise\":1600057014,\"sunset\":1600103087,\"temp\":{\"day\":292.05,\"min\":288.06,\"max\":292.26,\"night\":288.06,\"eve\":292.19,\"morn\":289.94},\"feels_like\":{\"day\":289.21,\"night\":287.97,\"eve\":291.04,\"morn\":286.5},\"pressure\":1025,\"humidity\":75,\"dew_point\":287.65,\"wind_speed\":6.05,\"wind_deg\":301,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":87,\"pop\":0.2,\"rain\":0.2},{\"dt\":1600164000,\"sunrise\":1600143522,\"sunset\":1600189335,\"temp\":{\"day\":292.65,\"min\":287.41,\"max\":293.9,\"night\":289.3,\"eve\":292.86,\"morn\":287.41},\"feels_like\":{\"day\":293.29,\"night\":288.2,\"eve\":292.06,\"morn\":287.02},\"pressure\":1029,\"humidity\":71,\"dew_point\":287.27,\"wind_speed\":0.94,\"wind_deg\":156,\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":25,\"pop\":0},{\"dt\":1600250400,\"sunrise\":1600230030,\"sunset\":1600275583,\"temp\":{\"day\":292.17,\"min\":287.11,\"max\":295.06,\"night\":290.41,\"eve\":295.06,\"morn\":287.11},\"feels_like\":{\"day\":288.07,\"night\":289.39,\"eve\":293.02,\"morn\":283.65},\"pressure\":1019,\"humidity\":58,\"dew_point\":283.95,\"wind_speed\":6.15,\"wind_deg\":178,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":95,\"pop\":0},{\"dt\":1600336800,\"sunrise\":1600316538,\"sunset\":1600361831,\"temp\":{\"day\":288.8,\"min\":286.54,\"max\":290.02,\"night\":286.54,\"eve\":288.16,\"morn\":288.94},\"feels_like\":{\"day\":283.58,\"night\":282.23,\"eve\":282.58,\"morn\":287.42},\"pressure\":1016,\"humidity\":75,\"dew_point\":284.44,\"wind_speed\":8.01,\"wind_deg\":43,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":98,\"pop\":0}]}";
        System.out.println(check);



        WeatherDTO weather = DataMapper.mapJsonToWeatherDTO(check);
        System.out.println(Arrays.toString(weather.getDay()));
        //mam wykurwiście długą tabelę, teraz wystarczy odnieść się do jej indeksów... WOW...


    }
}

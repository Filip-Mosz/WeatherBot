package pl.sda.view;

import pl.sda.dao.LocationDAO;
import pl.sda.dao.WeatherDAO;
import pl.sda.dto.JSON.ReadingDTO;
import pl.sda.dto.WeatherDTO;
import pl.sda.inbound.DataMapper;
import pl.sda.inbound.WeatherDataProvider;
import pl.sda.model.Location;
import pl.sda.model.Weather;
import pl.sda.service.EntityService;
import pl.sda.view.table.TablePrinter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class WeatherManager {
    private static List<Weather> forecasts = new ArrayList<>();
    private List<Weather> locations = new ArrayList<>();



    private WeatherDAO weatherDAO;

    {
        weatherDAO = new WeatherDAO();
    }

    public void  printList() {
        forecasts = weatherDAO.readAll();

        TablePrinter<Weather> tablePrinter = new TablePrinter<Weather>()
                .withData(forecasts)
                .withColumn("Dzień", Weather::getForcastedDay)
                .withColumn("Temperatura", Weather::getStringValueOfTemp)
                .withColumn("Cieśnienie", Weather::getStringValueOfPressure)
                .withColumn("Wilgotność", Weather::getStringValueOfHumidity)
                .withColumn("Prędkość wiatru", Weather::getStringValueOfWindSpeed)
                .withColumn("Kierunek wiatru", Weather::getWindDirection);

        tablePrinter.printTable();

    }


    public void checkForecast() throws SQLException {
        Scanner scan = new Scanner(System.in);
        LocationDAO locationDAO = new LocationDAO();
        List<Location> locationList = locationDAO.readAll();



        System.out.println("wpisz lokację");
        String locationName = scan.nextLine();
        for (int i = 0; i < locationList.size(); i++) {
            if ((locationList.get(i).getName()).equals(locationName)) {

                //tu operacje
                System.out.println("It's alive");

                WeatherManager weatherManager = new WeatherManager();
                        weatherManager.getForecast(locationList.get(i));

            }
        }
    }

    private void getForecast(Location location) {
        String[] gps = location.getGPS_location().split(", ");
        String lat = gps[0];
        String lon = gps[1];
        StringBuilder url = new StringBuilder("https://api.openweathermap.org/data/2.5/onecall?lat=");
        url.append(lat);
        url.append("&lon=");
        url.append(lon);
        url.append("&exclude=current,hourly,minutely&appid=62e8e14917f87e5db0d505a8f50b4449");
        EntityService.create();

        EntityManager entityManager = EntityService.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = EntityService.entityManagerFactory().createEntityManager().getTransaction();

        String check = null;
        try {
            check = WeatherDataProvider.requestCurrentData(url.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        WeatherDTO weather = DataMapper.mapJsonToWeatherDTO(check);
        ReadingDTO readingDTO = weather.getReadingDTOOfDay().get(1);
        WeatherDAO addedWeather = WeatherDAO.map(readingDTO);

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Date forecastedDay = new Date(tomorrow.getYear(),
                tomorrow.getMonthValue(),
                tomorrow.getDayOfMonth());
        //System.out.println("Weather forecast for " + forecastedDay);
        addedWeather.setCityId(location.getId());
        addedWeather.setForecastedDay(forecastedDay);
        forecasts.add(new Weather(
                addedWeather.getTempDay(),
                addedWeather.getTempNight(),
                addedWeather.getPressure(),
                addedWeather.getHumidity(),
                addedWeather.getWindSpeed(),
                addedWeather.getWindDirection(),
                location.getId(),
                forecastedDay
        ));


        transaction.begin();
        weatherDAO.create(addedWeather);
        entityManager.persist(addedWeather);
        transaction.commit();
        EntityService.close();

        printList();
    }


}

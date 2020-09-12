package pl.sda.view;

import pl.sda.dao.LocationDAO;
import pl.sda.dao.WeatherDAO;
import pl.sda.model.Location;
import pl.sda.model.Weather;
import pl.sda.view.table.TablePrinter;

import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class WeatherManager {
    private List<Weather> forecasts = new ArrayList<>();
    private List<Weather> locations = new ArrayList<>();

    private WeatherDAO weatherDAO;

    {
        weatherDAO = new WeatherDAO();
    }

    public void printList() {
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
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Date forecastedDay = new Date(tomorrow.getYear(),
                tomorrow.getMonthValue(),
                tomorrow.getDayOfMonth());
        Scanner scan = new Scanner(System.in);
        LocationDAO locationDAO = new LocationDAO();
        List<Location> locationList = locationDAO.readAll();


        System.out.println("Weather forecast for " + forecastedDay);

        System.out.println("wpisz lokację");
        String locationName = scan.nextLine();
        for (int i = 0; i<locationList.size(); i++){
            if ((locationList.get(i)).getName() == locationName){

                //tu operacje
                System.out.println("It's alive");

            }
            else System.out.println("Nie odnaleziono lokacji o tej nazwie");
        }


    }
}

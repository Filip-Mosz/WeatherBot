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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherManager {
    private List<Weather> forecasts = new ArrayList<>();

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
                .withColumn("Kierunek wiatru", Weather::getStringValueOfWindDegree);

        tablePrinter.printTable();

    }

    public void checkForecast(){

        Date forcastedDay = new Date(LocalDate.now().getYear(),
                LocalDate.now().getMonthValue(),
                LocalDate.now().getDayOfMonth());
        System.out.println(forcastedDay);
    }
}

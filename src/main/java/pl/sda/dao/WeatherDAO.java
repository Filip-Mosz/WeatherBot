package pl.sda.dao;

import lombok.Getter;
import lombok.Setter;
import pl.sda.dto.JSON.ReadingDTO;
import pl.sda.model.Location;
import pl.sda.model.Weather;
import pl.sda.service.ConnectionDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class WeatherDAO {
    @Column(name = "temp_day")
    private float tempDay;
    @Column(name = "temp_night")
    private float tempNight;
    private float pressure;
    private float humidity;
    @Column(name = "wind_direction")
    private String windDirection;
    @Column(name = "wind_speed")
    private float windSpeed;
    @Column(name = "day")
    @Id
    private Date forecastedDay;
    @Column(name = "city_id")
    private String cityId;
//    //Temperature
//    private float temp; //in Kelwin
//    private int pressure;
//    private int humidity;

    //    //    @ManyToOne
//    private int id;
//    @Id
//    private Date forecastedDay;
    @Transient //pomija pole przy tworzeniu encji
    private final Connection dbConnection = ConnectionDB.create();
    @Transient
    private List<Weather> forecasts;


    public static WeatherDAO map(ReadingDTO readingDTO) {
        WeatherDAO result = new WeatherDAO();

        result.setTempDay(readingDTO.getTemp().getDay());
        result.setTempNight(readingDTO.getTemp().getNight());
        result.setPressure(readingDTO.getPressure());
        result.setHumidity(readingDTO.getHumidity());
        result.setWindDirection(readingDTO.getStringValueOfWind_deg());
        result.setWindSpeed(readingDTO.getWind_speed());


        return result;
    }

    public boolean create(WeatherDAO weather) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(
                    "INSERT INTO weatherdao (day, humidity, city_id, pressure, temp_day, wind_direction, wind_speed, temp_night)" +
                            "VALUES (?,?,?,?,?,?,?,?);");

            statement.setString(1, weather.getForecastedDay().toString());
            statement.setFloat(2, weather.getHumidity());
            statement.setString(3, weather.getCityId());
            statement.setFloat(4, weather.getPressure());
            statement.setFloat(5, weather.getTempDay());
            statement.setString(6, weather.getWindDirection());
            statement.setFloat(7, weather.getWindSpeed());
            statement.setFloat(8, weather.getTempNight());
            statement.executeUpdate();//ZAJEBISCIE WAZNA LINIJKA!!!!!
            statement.close();
        } catch (SQLException e) {
            System.err.print("DataBase Error! Forecast reading not added");
            return false;
        }
        return true;
    }

    public Weather read(Location location) {
        try (
                PreparedStatement statement = dbConnection.prepareStatement(
                        "SELECT * FROM weatherdao\n" +
                                "WHERE id=?;")
        ) {
            statement.setString(1, location.getId());
            statement.execute();//ZAJEBISCIE WAZNA LINIJKA!!!!!
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                this.tempDay = resultSet.getInt("temp_day");
                this.tempNight = resultSet.getInt("temp_night");
                this.pressure = resultSet.getInt("pressure");
                this.humidity = resultSet.getInt("humidity");
                this.windSpeed = resultSet.getFloat("wind_speed");
                this.windDirection = resultSet.getString("wind_direction");
                this.cityId = resultSet.getString("city_id");
                this.forecastedDay = resultSet.getDate("day");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return new Weather();
        }
        forecasts.add(new Weather(
                this.tempDay,
                this.tempNight,
                this.pressure,
                this.humidity,
                this.windSpeed,
                this.windDirection,
                this.cityId,
                this.forecastedDay));
        return new Weather(
                this.tempDay,
                this.tempNight,
                this.pressure,
                this.humidity,
                this.windSpeed,
                this.windDirection,
                this.cityId,
                this.forecastedDay);
    }

    public List<Weather> readAll() {
        forecasts = new ArrayList<>();

        try (
                PreparedStatement statement = dbConnection.prepareStatement(
                        "SELECT * FROM weatherdao;")
        ) {
            //statement.setInt(1, id);
            statement.execute();//ZAJEBISCIE WAZNA LINIJKA!!!!!
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                this.tempDay = resultSet.getInt("temp_day");
                this.pressure = resultSet.getInt("pressure");
                this.humidity = resultSet.getInt("humidity");
                this.windSpeed = resultSet.getFloat("wind_speed");
                this.windDirection = resultSet.getString("wind_direction");
                this.cityId = resultSet.getString("city_id");
                this.forecastedDay = resultSet.getDate("day");
                this.tempNight = resultSet.getInt("temp_night");

                forecasts.add(new Weather(
                        this.tempDay,
                        this.tempNight,
                        this.pressure,
                        this.humidity,
                        this.windSpeed,
                        this.windDirection,
                        this.cityId,
                        this.forecastedDay));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return forecasts;
        }
        return forecasts;
    }

    public boolean update(int id, Location location) {//refactor

        try (PreparedStatement statement = dbConnection.prepareStatement(
                "UPDATE weatherdao " +
                        "SET name = ?," +
                        "country_code = ?," +
                        "GPS_location = ?," +
                        "WHERE id = ?;")) {
            statement.setString(1, location.getName());
            statement.setString(2, location.getCountryCode());
            statement.setString(3, location.getGPS_location());
            statement.setInt(4, id);
            statement.executeUpdate();//ZAJEBISCIE WAZNA LINIJKA!!!!!

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean delete(Location location) {
        try (
                PreparedStatement statement = dbConnection.prepareStatement(
                        "DELETE FROM weatherdao\n" +
                                "WHERE id=?;")) {
            statement.setString(1, location.getId());
            statement.execute();//ZAJEBISCIE WAZNA LINIJKA!!!!!


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

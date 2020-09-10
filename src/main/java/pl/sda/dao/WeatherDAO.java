package pl.sda.dao;

import pl.sda.model.Location;
import pl.sda.model.Weather;
import pl.sda.service.ConnectionDB;

import javax.persistence.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WeatherDAO {
    //Temperature
    private float temp; //in Kelwin
    private int pressure;
    private int humidity;
    // Wind
    private float windSpeed;
    private int windDegree;
    //    @ManyToOne
    private int id;
    @Id
    private Date forecastedDay;
    @Transient //pomija pole przy tworzeniu encji
    private final Connection dbConnection = ConnectionDB.create();
    @Transient
    private List<Weather> forecasts;


    public boolean create(Weather weather) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(
                    "INSERT INTO weatherdao (forecastedDay, humidity, id, pressure, temp, winddegree, windSpeed)" +
                            "VALUES (?,?,?,?,?,?,?);");

            statement.setString(1, weather.getForcastedDay());
            statement.setInt(2, weather.getHumidity());
            statement.setInt(3, weather.getId());
            statement.setInt(4, weather.getPressure());
            statement.setFloat(5, weather.getTemp());
            statement.setInt(6, weather.getWindDegree());
            statement.setFloat(7, weather.getWindSpeed());
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
                this.temp = resultSet.getInt("temp");
                this.pressure = resultSet.getInt("pressure");
                this.humidity = resultSet.getInt("humidity");
                this.windSpeed = resultSet.getFloat("windspeed");
                this.windDegree = resultSet.getInt("winddegree");
                this.id = resultSet.getInt("id");
                this.forecastedDay = resultSet.getDate("forecastedday");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return new Weather();
        }
        forecasts.add(new Weather(
                this.temp,
                this.pressure,
                this.humidity,
                this.windSpeed,
                this.windDegree,
                this.id,
                this.forecastedDay));
        return new Weather(
                this.temp,
                this.pressure,
                this.humidity,
                this.windSpeed,
                this.windDegree,
                this.id,
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
                this.temp = resultSet.getInt("temp");
                this.pressure = resultSet.getInt("pressure");
                this.humidity = resultSet.getInt("humidity");
                this.windSpeed = resultSet.getFloat("windspeed");
                this.windDegree = resultSet.getInt("winddegree");
                this.id = resultSet.getInt("id");
                this.forecastedDay = resultSet.getDate("forecastedday");

                forecasts.add(new Weather(
                        this.temp,
                        this.pressure,
                        this.humidity,
                        this.windSpeed,
                        this.windDegree,
                        this.id,
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

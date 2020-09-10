package pl.sda.dao;

import pl.sda.model.Location;
import pl.sda.model.Temperature;
import pl.sda.model.Wind;
import pl.sda.service.ConnectionDB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private int id;
    @Id
    private LocalDate forecastedDay;
    @Transient //pomija pole przy tworzeniu encji
    private final Connection dbConnection = ConnectionDB.create();


    public boolean create(Location location) {//refactor
        try {
            PreparedStatement statement = dbConnection.prepareStatement(
                    "INSERT INTO Location (Id, GPS_location, country_code, name)" +
                            "VALUES (?,?,?,?);");
            statement.setString(1, location.getId());
            statement.setString(2, location.getGPS_location());
            statement.setString(3, location.getCountryCode());
            statement.setString(4, location.getName());
            statement.executeUpdate();//ZAJEBISCIE WAZNA LINIJKA!!!!!
            statement.close();
        } catch (SQLException e) {
            System.err.print("DataBase Error! Conditions reading not added");
            return false;
        }
        return true;
    }

//    public Location read(int id) {
//        try (
//                PreparedStatement statement = dbConnection.prepareStatement(
//                        "SELECT * FROM Location\n" +
//                                "WHERE id=?;")
//        ) {
//            statement.setInt(1, id);
//            statement.execute();//ZAJEBISCIE WAZNA LINIJKA!!!!!
//            ResultSet resultSet = statement.getResultSet();
//            while (resultSet.next()) {
//                this.name = resultSet.getString("name");
//                this.Id = resultSet.getString("Id");
//                this.countryCode = resultSet.getString("country_code");
//                this.GPS_location = resultSet.getString("GPS_location");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new Location();
//        }
//        locations.add(new Location(
//                this.Id,
//                this.name,
//                this.countryCode,
//                this.GPS_location));
//        return new Location(
//                this.Id,
//                this.name,
//                this.countryCode,
//                this.GPS_location);
//    }
//
//    public List<Location> readAll() {
//        locations = new ArrayList<>();
//
//        try (
//                PreparedStatement statement = dbConnection.prepareStatement(
//                        "SELECT * FROM Location;")
//        ) {
//            //statement.setInt(1, id);
//            statement.execute();//ZAJEBISCIE WAZNA LINIJKA!!!!!
//            ResultSet resultSet = statement.getResultSet();
//            while (resultSet.next()) {
//                this.name = resultSet.getString("name");
//                this.Id = resultSet.getString("Id");
//                this.countryCode = resultSet.getString("country_code");
//                this.GPS_location = resultSet.getString("GPS_location");
//
//                locations.add(new Location(
//                        this.Id,
//                        this.name,
//                        this.countryCode,
//                        this.GPS_location));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return locations;
//        }
//        return locations;
//    }

    public boolean update(int id, Location location) {

        try (PreparedStatement statement = dbConnection.prepareStatement(
                "UPDATE Location " +
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

    public boolean delete(int id) {
        try (
                PreparedStatement statement = dbConnection.prepareStatement(
                        "DELETE FROM Location\n" +
                                "WHERE id=?;")) {
            statement.setInt(1, id);
            statement.execute();//ZAJEBISCIE WAZNA LINIJKA!!!!!


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

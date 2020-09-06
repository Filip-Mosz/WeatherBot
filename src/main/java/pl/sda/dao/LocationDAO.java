package pl.sda.dao;

import pl.sda.model.Location;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO {
    private String Id;
    private String name;
    private String GPS_location;
    private String countryCode;

    private List<Location> locations;

    private static final String URL = "jdbc:mysql://localhost:3306/weatherbot?serverTimezone=Europe/Warsaw";
    private static final String USER = "weatherbot";
    private static final String PASSWORD = "weatherbot";
    private final Connection dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);

    public LocationDAO() throws SQLException {


    }

    public boolean create(Location location) {//works
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
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Location read(int id) {
        try (
                PreparedStatement statement = dbConnection.prepareStatement(
                        "SELECT * FROM Location\n" +
                                "WHERE id=?;")
        ) {
            statement.setInt(1, id);
            statement.execute();//ZAJEBISCIE WAZNA LINIJKA!!!!!
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                this.name = resultSet.getString("name");
                this.Id = resultSet.getString("Id");
                this.countryCode = resultSet.getString("country_code");
                this.GPS_location = resultSet.getString("GPS_location");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return new Location();
        }
        locations.add(new Location(
                this.Id,
                this.name,
                this.countryCode,
                this.GPS_location));
        return new Location(
                this.Id,
                this.name,
                this.countryCode,
                this.GPS_location);
    }

    public List<Location> readAll() {
        locations = new ArrayList<>();

        try (
                PreparedStatement statement = dbConnection.prepareStatement(
                        "SELECT * FROM Location;")
        ) {
            //statement.setInt(1, id);
            statement.execute();//ZAJEBISCIE WAZNA LINIJKA!!!!!
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                this.name = resultSet.getString("name");
                this.Id = resultSet.getString("Id");
                this.countryCode = resultSet.getString("country_code");
                this.GPS_location = resultSet.getString("GPS_location");

                locations.add(new Location(
                        this.Id,
                        this.name,
                        this.countryCode,
                        this.GPS_location));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return locations;
        }
        return locations;
    }

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

    public List<Location> getLocations() {
        return locations;
    }
}

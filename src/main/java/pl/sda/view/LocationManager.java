package pl.sda.view;

import pl.sda.dao.LocationDAO;
import pl.sda.model.Coordinates;
import pl.sda.model.Location;
import pl.sda.service.EntityService;
import pl.sda.view.table.TablePrinter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocationManager {
    private final List<Location> locations = new ArrayList<>();


    LocationDAO locationDAO; //[powinno zwracać lstę]

    {
        try {
            locationDAO = new LocationDAO();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void printList() {

        //System.out.println(locationDAO.getLocations());

        TablePrinter<Location> tablePrinter = new TablePrinter<Location>()
                .withData(locations)
                .withColumn("ID", location -> ((Location) location).getId())
                .withColumn("Współrzędne", location -> ((Location) location).getGPS_location())
                .withColumn("Kraj", location -> ((Location) location).getCountryCode())
                .withColumn("Nazwa", location -> ((Location) location).getName());

        tablePrinter.printTable();

    }

    public void addLocation() {
        EntityService.create();

        Location addedLocation = new Location();
        Coordinates coordinates = new Coordinates();
        Scanner scan = new Scanner(System.in);

        EntityManager entityManager = EntityService.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = EntityService.entityManagerFactory().createEntityManager().getTransaction();

        ConsoleManager.clrscr();
        System.out.print("Type ID: ");
        addedLocation.setId(new Scanner(System.in).nextLine());
        System.out.print("Type name: ");
        addedLocation.setName(scan.nextLine());
        System.out.print("Type longitude: ");
        coordinates.setLongitude(Double.parseDouble(scan.next()));
        System.out.print("Type latitude: ");
        coordinates.setLatitude(Double.parseDouble(scan.next()));
        addedLocation.setGPS_location(coordinates.toString());
        //ToDo koordynawy mają być podawane w formule N0,0 W0,0
        System.out.print("Type two letters country code: "); //kusi na enum
        Scanner scan2 = new Scanner(System.in);
        addedLocation.setCountryCode(scan2.nextLine());

        transaction.begin();
        locationDAO.create(addedLocation);
        locations.add(addedLocation);
        entityManager.persist(addedLocation);
        transaction.commit();
        EntityService.close();
    }
}

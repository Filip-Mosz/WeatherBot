package pl.sda.view;

import pl.sda.dao.LocationDAO;
import pl.sda.model.Coordinates;
import pl.sda.model.Location;
import pl.sda.service.EntityService;
import pl.sda.service.LocationMenu;
import pl.sda.view.table.TablePrinter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocationManager {
    private List<Location> locations = new ArrayList<>();


    LocationDAO locationDAO; //[powinno zwracać listę]

    {
        try {
            locationDAO = new LocationDAO();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void printList() {
        locations = locationDAO.readAll();

        TablePrinter<Location> tablePrinter = new TablePrinter<Location>()
                .withData(locations)
                .withColumn("ID", Location::getId)
                .withColumn("Współrzędne", Location::getGPS_location)
                .withColumn("Kraj", Location::getCountryCode)
                .withColumn("Nazwa", Location::getName);

        tablePrinter.printTable();

    }

    public void addLocation() {
        EntityService.create();

        Location addedLocation = new Location();


        EntityManager entityManager = EntityService.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = EntityService.entityManagerFactory().createEntityManager().getTransaction();

        ConsoleManager.clrscr();
        boolean locationIsNull;
        do {
            LocationMenu.printMenu(addedLocation);
            locationIsNull = false;
            if (
                    addedLocation.getName().equals("") ||
                            addedLocation.getGPS_location().equals("") ||
                            addedLocation.getCountryCode().equals("") ||
                            addedLocation.getId().equals("")
            ) {
                System.out.println("No value may be empty. Try again.");
                locationIsNull = true;
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    System.out.println("Sleeping thread interrupted!");
                }
            }
        } while (locationIsNull);
        locations.add(addedLocation);


        transaction.begin();
        locationDAO.create(addedLocation);
        entityManager.persist(addedLocation);
        transaction.commit();
        EntityService.close();
    }


}

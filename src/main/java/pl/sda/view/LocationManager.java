package pl.sda.view;

import pl.sda.EntityService;
import pl.sda.dto.Coordinates;
import pl.sda.dto.Location;
import pl.sda.dto.Location;
import pl.sda.model.CoordinatesDTO;
import pl.sda.view.table.TablePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocationManager {
    private List<Location> locations = new ArrayList<>();

    public void printList() {
        TablePrinter<Location> tablePrinter = new TablePrinter<Location>()
                .withData(locations)
                .withColumn("Nazwa", location -> ((Location) location).getName())
                .withColumn("Współrzędne", location -> ((Location) location).getGPS_location());

        tablePrinter.printTable();

    }

    public void addLocation(){
        EntityService.create();

        Location addedLocation = new Location();
        Coordinates coordinates = new Coordinates();
        Scanner scan = new Scanner(System.in);

            ConsoleManager.clrscr();
            System.out.println("Type name:_");
            addedLocation.setName(scan.nextLine());
        System.out.println("Type longitude:_");
        coordinates.setLongitude(scan.nextLine);
        System.out.println("Type latitude:_");
        coordinates.setLatitude(scan.nextLine);
addedLocation.setGPS_location(coordinates);


            locations.add(addedLocation);

        EntityService.close();
    }
}

package pl.sda.view;

import pl.sda.EntityService;
import pl.sda.model.Coordinates;
import pl.sda.model.Location;
import pl.sda.view.table.TablePrinter;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocationManager {
    private List<Location> locations = new ArrayList<>();
    {
        locations.add(new Location("3099424", "Gdynia", (new Coordinates(18.531879,54.51889).toString()),"PL"));

        Location gdynia = locations.get(0);
        EntityService.create();

        EntityService.entityManagerFactory().createEntityManager().persist(gdynia);
        EntityService.close();
    }
    //LocationDAO dao = new LocationDAO; //[powinno zwracać lstę]

    public void printList() {

        TablePrinter<Location> tablePrinter = new TablePrinter<Location>()
                .withData(locations)
                .withColumn("ID", location -> ((Location) location).getId())
                .withColumn("Nazwa", location -> ((Location) location).getName())
                .withColumn("Współrzędne", location -> ((Location) location).getGPS_location().toString())
                .withColumn("Kraj", location -> ((Location)location).getCountryCode())
                ;

        tablePrinter.printTable();

    }

    public void addLocation() {
        EntityService.create();

        Location addedLocation = new Location();
        Coordinates coordinates = new Coordinates();
        Scanner scan = new Scanner(System.in);

        EntityManager entityManager = EntityService.entityManagerFactory().createEntityManager();

        ConsoleManager.clrscr();
        System.out.println("Type name:_");
        addedLocation.setName(scan.nextLine());
        System.out.println("Type longitude:_");
        coordinates.setLongitude(Double.parseDouble(scan.next()));
        System.out.println("Type latitude:_");
        coordinates.setLatitude(Double.parseDouble(scan.next()));
        addedLocation.setGPS_location(coordinates.toString());

        locations.add(addedLocation);
        entityManager.persist(addedLocation);

        EntityService.close();
    }
}

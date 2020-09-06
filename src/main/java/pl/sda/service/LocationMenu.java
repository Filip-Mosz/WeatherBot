package pl.sda.service;

import pl.sda.model.Coordinates;
import pl.sda.model.Location;

import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public class LocationMenu {
    public static void printMenu(Location location) {
        Coordinates coordinates = new Coordinates();
        Scanner scan = new Scanner(System.in);

            System.out.print("Type ID: ");
            location.setId(scan.nextLine());
            System.out.print("Type name: ");
            location.setName(scan.nextLine());
            System.out.print("Type longitude: ");
            coordinates.setLongitude(Double.parseDouble(scan.next()));
            System.out.print("Type latitude: ");
            coordinates.setLatitude(Double.parseDouble(scan.next()));
            location.setGPS_location(coordinates.toString());
            //ToDo koordynawy mają być podawane w formule N0,0 W0,0
            System.out.print("Type two letters country code: "); //kusi na enum
            Scanner scan2 = new Scanner(System.in);
            location.setCountryCode(scan2.nextLine());


    }
}

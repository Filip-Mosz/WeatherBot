package pl.sda.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleManager {

    private LocationManager locationManager = new LocationManager();
    private WeatherManager weatherManager = new WeatherManager();

    public void start() {
        char userChoice = ' ';
        while (userChoice != 'q') {
            printMenu();
            userChoice = readChar();
            executeAction(userChoice);
        }

    }

    private void printMenu() {
        clrscr();
        System.out.println("Menu:");
        System.out.println("1 - Lista lokacji");
        System.out.println("2 - Dodaj lokację");
        System.out.println("3 - Sprawdź pogodę");
        System.out.println();
        System.out.println("q - wyjście");

    }

    public static void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }


    private void executeAction(char userChoice) {
        switch (userChoice) {
            case '1':
                locationManager.printList();
                pressEnterKeyToContinue();
                break;
            case '2':
                locationManager.addLocation();
            case '3':
                try {
                    weatherManager.checkForecast();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }

    public void pressEnterKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        readChar();
    }

    private char readChar() {
        Scanner s = new Scanner(System.in);
        return (char) s.nextLine().chars().findFirst().orElse(0);

    }
}

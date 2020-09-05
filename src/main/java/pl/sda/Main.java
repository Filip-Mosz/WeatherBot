package pl.sda;

import pl.sda.view.ConsoleManager;

public class Main {

    public static void main(String[] args) {
        EntityService.create();


        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.start();


        EntityService.close();
    }


}

package pl.sda;

import pl.sda.dto.LocationDTO;
import pl.sda.service.EntityService;
import pl.sda.view.ConsoleManager;

public class Main {

    public static void main(String[] args) {
        EntityService.create();


        ConsoleManager consoleManager = new ConsoleManager();

        consoleManager.start();


        EntityService.close();
    }


}
//dto=model
//komunikacja z bazą w pakiecie dao
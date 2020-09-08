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
//
//TODO LocationDTO check przygotować na przyjęcie zewnętrznego URLa; zawrzeć APIkey w stałej, przyjmować nazwę miasta i pobierać z listy jego id
//TODO zmniejszyć ilość pół w WeatherDTO i przygotować WeatherDAO(zawrzeć czas requesta)
//TODO posprzątać ten chlew -> wywalić niepotrebne klasy
//TODO testy na wszystko; w razie potrzeby refactor metod

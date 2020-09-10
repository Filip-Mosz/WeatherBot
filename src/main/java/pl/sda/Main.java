package pl.sda;

import pl.sda.dao.WeatherDAO;
import pl.sda.dto.LocationDTO;
import pl.sda.service.EntityService;
import pl.sda.view.ConsoleManager;

public class Main {
//ISTOTNE! pogoda ma być domyślnie pobierana dla dnia następnego!

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
//TODO zawrzeć APIkey w stałej, przyjmować nazwę miasta i pobierać z listy jego id
//TODO request pogody: user wpisuje nazwę; na liście lokacji szukamy nazwy i element.getId; id wysyłamy weatherDao jako argument funkcji getForcast
//TODO przemodelować encję weaterDao na nowego jsona
//TODO odwołania do JSONGetter podmienić na odwołania JsonService.get();
//TODO posprzątać ten chlew -> wywalić niepotrebne klasy
//TODO testy na wszystko; w razie potrzeby refactor metod


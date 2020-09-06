package pl.sda;

import pl.sda.dto.LocationDTO;

public class JsonCheck {
    public static void main(String[] args) {
        LocationDTO dtoCheck = new LocationDTO();
        String check = dtoCheck.JSONGetter().toString();
        System.out.println(check);
    }
}

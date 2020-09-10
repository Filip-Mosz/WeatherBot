package pl.sda.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinates {
    public Coordinates() {
    }

    public Coordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    private double longitude;
    private double latitude;

    @Override
    public String toString() {
        return  longitude + ", " + latitude;
    }

}

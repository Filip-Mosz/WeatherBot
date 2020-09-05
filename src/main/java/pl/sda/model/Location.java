package pl.sda.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Location {
    public Location() {
    }

    public Location(String id, String name, String GPS_location, @NonNull String countryCode) {
        Id = id;
        this.name = name;
        this.GPS_location = GPS_location;
        this.countryCode = countryCode;
    }

    @Id
private String Id;
private String name;
private String GPS_location;
@NonNull
private String countryCode;

}

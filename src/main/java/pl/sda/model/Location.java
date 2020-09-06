package pl.sda.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Location {
    public Location() {
    }

    public Location(@NonNull String id, @NonNull String name, String GPS_location, @NonNull String countryCode) {
        this.Id = id;
        this.name = name;
        this.GPS_location = GPS_location;
        this.countryCode = countryCode;
    }

    @Id
    @NonNull
private String Id;
    @NonNull
private String name;
private String GPS_location;
@NonNull
@Column(name = "country_code")
private String countryCode;

}

package pl.sda.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {

private String name;
@Id
private String GPS_location;
}

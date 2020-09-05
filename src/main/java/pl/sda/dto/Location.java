package pl.sda.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Location {

private String name;
@Id
private String GPS_location;
}

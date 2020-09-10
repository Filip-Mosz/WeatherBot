package pl.sda.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class Temperature {
    private Float day; //K -> C
    private Integer night;

    public float getDay(){
        return this.day - 273;
    }

    public float getNight(){
        return this.night - 273;
    }
}

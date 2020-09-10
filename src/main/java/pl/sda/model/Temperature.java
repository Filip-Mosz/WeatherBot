package pl.sda.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temperature {
    private float temp; //in Kelwin
    private int pressure;
    private int humidity;

    public float getTemp(){
        return this.temp - 273;
    }
}

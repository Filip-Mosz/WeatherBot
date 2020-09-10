package pl.sda.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Weather {
    private float temp; //in Kelwin
    private int pressure;
    private int humidity;
    // Wind
    private float windSpeed;
    private int windDegree;
    private int id;
    private Date forcastedDay;

    public Weather() {
    }

    public Weather(float temp, int pressure, int humidity, float windSpeed, int windDegree, int id, Date forcastedDay) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
        this.id = id;
        this.forcastedDay = forcastedDay;
    }

    public String getForcastedDay() {
        return forcastedDay.toString();
    }

    public String getStringValueOfTemp() {
        return String.valueOf(temp);
    }

    public String getStringValueOfWindSpeed() {
        return String.valueOf(windSpeed);
    }

    public String getStringValueOfPressure() {
        return String.valueOf(pressure);
    }

    public String getStringValueOfHumidity() {
        return String.valueOf(humidity);
    }

    public String getStringValueOfWindDegree() {
        String direction = "N";
        if (22.5 < windDegree && windDegree < 67.5){
            direction = "NE";
        } else if (67.5 < windDegree && windDegree < 112.5){
            direction = "E";
        } else if (112.5 < windDegree && windDegree < 157.5){
            direction = "SE";
        } else if (157.5 < windDegree && windDegree < 202.5){
            direction = "S";
        } else if (202.5 < windDegree && windDegree < 247.5){
            direction = "SW";
        } else if (247.5 < windDegree && windDegree < 292.5){
            direction = "W";
        } else if (292.5 < windDegree && windDegree < 337.5){
            direction = "NW";
        }
        return direction;
    }
}

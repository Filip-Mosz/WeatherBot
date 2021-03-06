package pl.sda.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Weather {
    private float tempDay;
    private float tempNight;
    private float pressure;
    private float humidity;
    // Wind
    private float windSpeed;
    private String windDirection;
    private String cityId;
    private Date forecastedDay;

    public Weather() {
    }

    public Weather(float tempDay, float tempNight, float pressure, float humidity, float windSpeed, String windDirection, String cityId, Date forecastedDay) {
        this.tempDay = tempDay;
        this.tempNight = tempNight;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.cityId = cityId;
        this.forecastedDay = forecastedDay;
    }

    public String getForecastedDay() {
        return forecastedDay.toString();
    }

    public String getStringValueOfTempDay() {
        return String.valueOf(tempDay);
    }

    public String getStringValueOfTempNight() {
        return String.valueOf(tempNight);
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

}

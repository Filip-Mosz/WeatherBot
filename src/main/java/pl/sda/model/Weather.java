package pl.sda.model;

import java.time.LocalDate;

public class Weather {
    private float temp; //in Kelwin
    private int pressure;
    private int humidity;
    // Wind
    private float windSpeed;
    private int windDegree;
    private int id;
    private LocalDate forcastedDay;
}

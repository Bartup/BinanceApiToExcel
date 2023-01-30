package org.example.util;

import java.util.Comparator;
import java.util.Date;

public class Kline {

    public String name;
    public Date openingDate;
    public Date lowestDate;
    public float low;
    public float high;
    public float current;
    public float open;
    public float growth;
    public float fall;

    public Kline(String name, Date openingDate, float low, float high, float current, float open, Date lowestDate) {
        this.name = name;
        this.openingDate = openingDate;
        this.low = low;
        this.high = high;
        this.current = current;
        this.open = open;
        this.growth = current/low * 100;
        this.fall = current/high * 100;
        this.lowestDate = lowestDate;
    }

    @Override
    public String toString() {
        return "Kline{" +
                "name='" + name + '\'' +
                ", openingDate=" + openingDate.toGMTString().substring(0, openingDate.toGMTString().length() - 12) +
                ", lowestDate=" + lowestDate +
                ", low=" + low +
                ", high=" + high +
                ", current=" + current +
                ", open=" + open +
                ", growth=" + growth + "%" +
                ", fall=" + fall + "%" +
                '}';
    }
}

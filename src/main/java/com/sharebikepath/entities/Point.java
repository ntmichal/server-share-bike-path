package com.sharebikepath.entities;


public class Point {


//    TODO change how it is stored
    private double latitude;
    private double longitude;

    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Point setLatitude(long latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public Point setLongitude(long longitude) {
        this.longitude = longitude;
        return this;
    }
}

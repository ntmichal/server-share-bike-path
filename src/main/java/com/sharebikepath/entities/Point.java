package com.sharebikepath.entities;

public class Point {

    private long latitude;
    private long longitude;

    public long getLatitude() {
        return latitude;
    }

    public Point setLatitude(long latitude) {
        this.latitude = latitude;
        return this;
    }

    public long getLongitude() {
        return longitude;
    }

    public Point setLongitude(long longitude) {
        this.longitude = longitude;
        return this;
    }
}

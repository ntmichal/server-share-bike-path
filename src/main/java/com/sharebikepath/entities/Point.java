package com.sharebikepath.entities;


import com.sharebikepath.dto.PointDTO;

public class Point {

    private Long id;
    private double latitude;
    private double longitude;

    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static Point PointFromPointDTO(PointDTO pointDTO){
        return new Point(pointDTO.getLatitude(), pointDTO.getLongitude());
    }
}

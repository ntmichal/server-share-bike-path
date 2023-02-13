package com.sharebikepath.entities;


import com.sharebikepath.dto.PointDTO;

public class Point {

    private Long id;
    private double latitude;
    private double longitude;

    public Point(double longitude, double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Point(Long id,double longitude, double latitude) {
        this.id = id;
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

    public Point setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public Point setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Point updateLonLat(Point point){
        this.setLatitude(point.getLatitude());
        this.setLongitude(point.getLongitude());
        return this;
    }

    public static Point PointFromPointDTO(PointDTO pointDTO){
        return new Point(pointDTO.getLongitude(), pointDTO.getLatitude());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.latitude, latitude) != 0) return false;
        if (Double.compare(point.longitude, longitude) != 0) return false;
        return id != null ? id.equals(point.id) : point.id == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

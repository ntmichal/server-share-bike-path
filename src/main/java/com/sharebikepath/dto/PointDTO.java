package com.sharebikepath.dto;

import com.sharebikepath.entities.Point;

public class PointDTO {
    private double latitude;
    private double longitude;

    public PointDTO(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof PointDTO)){
            return false;
        }
        PointDTO point = (PointDTO) obj;
        return point.latitude == latitude
                && point.longitude == longitude;

    }
    public static PointDTO PointDTOFromPoint(Point point){
        return new PointDTO(point.getLatitude(), point.getLongitude());
    }
}

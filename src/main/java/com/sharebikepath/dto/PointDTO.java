package com.sharebikepath.dto;

import com.sharebikepath.entities.Point;

public class PointDTO {

    private Long id;
    private double latitude;
    private double longitude;

    public PointDTO() {
    }

    public PointDTO(double longitude, double latitude) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        PointDTO pointDTO = new PointDTO();
        pointDTO.setId(point.getId());
        pointDTO.setLatitude(point.getLatitude());
        pointDTO.setLongitude(point.getLongitude());
        return pointDTO;
    }
}

package com.sharebikepath.dto;

import com.sharebikepath.dto.builder.MeetingDTOBuilder;

import java.util.ArrayList;
import java.util.List;

public class MeetingDTO {

    private String name;
    private List<PointDTO> points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PointDTO> getPoints() {
        return points;
    }

    public void setPoints(List<PointDTO> points) {
        this.points = points;
    }

    public void addPoint(PointDTO point){
        if(points == null){
            points = new ArrayList<>();
        }
        points.add(point);
    }

    public static MeetingDTOBuilder builder(){
        return new MeetingDTOBuilder();
    }
}

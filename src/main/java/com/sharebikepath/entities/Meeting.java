package com.sharebikepath.entities;

import com.sharebikepath.entities.builder.MeetingBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class Meeting {

    private UUID meetingId;
    private String name;
    private List<Point> points;

    public UUID getMeetingId() {
        return meetingId;
    }


    public String getName() {
        return name;
    }

    public Meeting() {
    }

    public Meeting setMeetingId(UUID meetingId) {
        this.meetingId = meetingId;
        return this;
    }

    public Meeting setName(String name) {
        this.name = name;
        return this;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Meeting setPoints(List<Point> points) {
        this.points = points;
        return this;
    }
    public Meeting addPoint(Point point){
        if(this.points == null){
            this.points = new ArrayList<>();
        }
        this.points.add(point);
        return this;
    }

    public Point updatePoint(Point point) {

        AtomicReference<Point> modifiedPoint = new AtomicReference<>();
        points.forEach((pointVar) -> {
            if (pointVar.getId() == point.getId()) {
                pointVar.updateLonLat(point);
                modifiedPoint.set(pointVar);
            }
        });

        if(modifiedPoint.get() == null){
            throw new RuntimeException("Waypoint not found!");
        }
        return modifiedPoint.get();


    }
    public static MeetingBuilder builder(){
        return new MeetingBuilder();
    }

}

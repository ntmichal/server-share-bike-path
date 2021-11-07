package com.sharebikepath.entities;

import com.sharebikepath.entities.builder.MeetingBuilder;

import java.util.List;
import java.util.UUID;

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

    public static MeetingBuilder builder(){
        return new MeetingBuilder();
    }

}

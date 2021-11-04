package com.sharebikepath.entities;

import com.sharebikepath.entities.builder.MeetingBuilder;

import java.util.UUID;

public class Meeting {

    private UUID meetingId;
    private String name;

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

    public static MeetingBuilder builder(){
        return new MeetingBuilder();
    }

}

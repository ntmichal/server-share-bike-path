package com.sharebikepath.entities.builder;

import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MeetingBuilder{

        private UUID id;
        private String name;
        private List<Point> pointList;

        public MeetingBuilder() {
        }

        public MeetingBuilder setID(UUID uuid){
            this.id = uuid;
            return this;
        }
        public MeetingBuilder setName(String name){
            this.name = name;
            return this;
        }

        public MeetingBuilder addPoint(Point point){
            if(pointList == null){
                pointList = new ArrayList<>();
                pointList.add(point);
            }else{
                pointList.add(point);
            }
            return this;
        }

        public MeetingBuilder setPoints(List<Point> pointList){
            pointList = pointList;
            return this;
        }

        public Meeting build(){
            Meeting meeting = new Meeting();
            meeting.setMeetingId(id);
            meeting.setName(name);
            meeting.setPoints(pointList);
            return meeting;
        }


}

